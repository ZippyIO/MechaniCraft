package mechanicraft;

import mechanicraft.blocks.BlockAnvilCraft;
import mechanicraft.blocks.BlockBetterTable;
import mechanicraft.blocks.BlockHighSpeedFurnace;
import mechanicraft.blocks.BlockInputFurnace;
import mechanicraft.blocks.BlockLavaFurnace;
import mechanicraft.blocks.BlockPML2;
import mechanicraft.blocks.BlockProjectTable;
import mechanicraft.blocks.BlockRedFurnace;
import mechanicraft.blocks.BlockSolarFurnace;
import mechanicraft.blocks.BlockSpiritTable;
import mechanicraft.blocks.BlockSteamFurnace;
import mechanicraft.blocks.BlockSwissMinningBlock;
import mechanicraft.explosion.BlockTntFiga;
import mechanicraft.info.MechaTab;
import mechanicraft.info.Names;
import mechanicraft.items.ItemHammer;
import mechanicraft.items.ItemHandSaw;
import mechanicraft.items.ItemNail;
import mechanicraft.items.ItemPortableCraft;
import mechanicraft.items.ItemWrench;
import mechanicraft.proxy.CommonProxy;
import mechanicraft.render.RenderHighSpeed;
import mechanicraft.render.RenderInpBlock;
import mechanicraft.render.RenderLavaBlock;
import mechanicraft.render.RenderRedFurnace;
import mechanicraft.render.RenderSolarFurnace;
import mechanicraft.render.RenderSteamFurnace;
import mechanicraft.tileentity.TePT;
import mechanicraft.tileentity.TileEntityHighSpeedFurnace;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.MLProp;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "MechaniCraft", name = "MechaniCraft", version = "0.1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)


public class MechaniCraft 
{
	@Instance("MechaniCraft")
	public static MechaniCraft instance;
	public static MechaTab tab = new MechaTab("mechanicraft");
	
	public static Block PML2Block;
	public static int RANGE;

	@MLProp(name="radius", info="The mid-size radius of destruction for the laser.", min=1.0D, max=64.0D)
	public static int RADIUS;
	public static Block PML = null;

	@MLProp(name="bedrock", info="Can laser burn through bedrock? (1=Yes, 0=No)", min=0.0D, max=1.0D)
	public static int BEDROCK;

	@MLProp(name="drop", info="Whether or not block's destroyed by the laser will drop as items (1=Yes, 0=No)", min=0.0D, max=1.0D)
	public static int DROP;

	@MLProp(name="selectfire", info="Drop everything but cobblestone, dirt, gravel, sand, or stone.", min=0.0D, max=1.0D)
	public static int SELECTFIRE;

	@MLProp(name="lavatunnel", info="Laser seals off lava flows for safer mining", min=0.0D, max=1.0D)
	public static int LAVATUNNEL;

	@MLProp(name="aquatunnel", info="Laser creates tunnels through water", min=0.0D, max=1.0D)
	public static int AQUATUNNEL;

	@MLProp(name="blockID", info="Block ID for the laser.", min=1.0D, max=255.0D)
	public static int PMLID;

	
	//Gui Handlers
	private GuiHandler guiHandler = new GuiHandler();
	
	
	//Items / Blocks - IDs
	public static Item portableCraft;
	public static Item hammer;
	public static Item nail;
	public static Item handsaw;
	public static Block forge;
	public static Block bettertable;
	public static Block lavafurnace;
	public static Block highspeed;
	public static Block doubleinput;
	public static Block steamfurnace;
	public static Block projecttable;
	public static Block spiritable;
	public static Block solarfurnace;
	public static Block swissblock;
	public static Block driller;
	public static Block redfurnace;
	//TODO Test TNT
	public static Block freezetnt;
	public static Block softCopper;
	
	//TODO COMPRESSOR IC2 STUFF
	public static Block repairTable;
	public static Item wrench;
    //Active furnaces
	public static Block lavaActive;
	public static Block steamActive;
	public static Block solarActive;
	public static Block redActive;
	public static Block swissActive;
	public static Block hspeedActive;
	public static Block doubleinputActive;
	//Double Input furnace stuff, let it go..
	public static int item1 = 286;
	public static int item2 = 286;

	
	@SidedProxy(clientSide = "mechanicraft.proxy.ClientProxy", serverSide = "mechanicraft.proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
	{
		
		
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) 
	{
		//Initialize items.
		portableCraft = new ItemPortableCraft(2900).setUnlocalizedName("portableCraft").setCreativeTab(CreativeTabs.tabBlock);
		nail = new ItemNail(2901).setUnlocalizedName(Names.NAIL_NAME_UNLOCALIZED);
		handsaw = new ItemHandSaw(2902).setUnlocalizedName(Names.HANDSAW_NAME_UNLOCALIZED);
		hammer = new ItemHammer(2903).setUnlocalizedName(Names.HAMMER_NAME_UNLOCALIZED);
		wrench = new ItemWrench(2904, Names.WRENCH_NAME, Names.WRENCH_NAME_UNLOCALIZED, 1, "mechanicraft:wrench");
		//Initialize blocks
		forge = new BlockAnvilCraft(3700).setCreativeTab(tab).setUnlocalizedName(Names.ANVIL_NAME_UNLOCALIZED);
		bettertable = new BlockBetterTable(3701).setCreativeTab(tab).setUnlocalizedName(Names.BETTER_TABLE_NAME_UNLOCALIZED);
		lavafurnace = new BlockLavaFurnace(3702, false).setCreativeTab(tab).setUnlocalizedName(Names.LAVAF_NAME_UNLOCALIZED);
		steamfurnace = new BlockSteamFurnace(3703, false).setCreativeTab(tab).setUnlocalizedName(Names.STEAMF_NAME_UNLOCALIZED);
		highspeed = new BlockHighSpeedFurnace(3704, false).setCreativeTab(tab).setUnlocalizedName(Names.HSPEEDF_NAME_UNLOCALIZED);
		doubleinput = new BlockInputFurnace(3705, false).setCreativeTab(tab).setUnlocalizedName(Names.DOUBLEF_NAME_UNLOCALIZED);
		solarfurnace = new BlockSolarFurnace(3706, false).setCreativeTab(tab).setUnlocalizedName(Names.SOLARF_NAME_UNLOCALIZED);
		redfurnace = new BlockRedFurnace(3707, false).setCreativeTab(tab).setUnlocalizedName(Names.REDF_NAME_UNLOCALIZED);
		projecttable = new BlockProjectTable(3708).setCreativeTab(tab).setUnlocalizedName(Names.PROJECT_TABLE_NAME_UNLOCALIZED);
		spiritable = new BlockSpiritTable(3709).setCreativeTab(tab).setUnlocalizedName(Names.SPIRIT_TABLE_NAME_UNLOCALIZED);
		swissblock = new BlockSwissMinningBlock(3710, false, false).setCreativeTab(tab).setUnlocalizedName(Names.SWISS_TABLE_NAME_UNLOCALIZED);
		driller = new BlockPML2(3711).setCreativeTab(tab).setUnlocalizedName(Names.DRILLER_NAME_UNLOCALIZED);
		freezetnt = new BlockTntFiga(3800).setUnlocalizedName("randomshit");
		//Initialize active furnaces
		lavaActive = new BlockLavaFurnace(3102, true);
		steamActive = new BlockSteamFurnace(3103, true);
		hspeedActive = new BlockHighSpeedFurnace(3104, true);
		doubleinputActive = new BlockInputFurnace(3105, true);
		solarActive = new BlockSolarFurnace(3106, true);
		redActive = new BlockRedFurnace(3107, true);
		swissActive = new BlockSwissMinningBlock(3108, true, false);
		//Gases
		
		
		//Add everything in game.
		addBlocksIngame();
		otherRegistries();
		registerRecipes();
		
		
		proxy.registerRenderThings();
		proxy.registerTileEntitySpecialRenderer();
		
	}
	
	
	//Actually adding everything: blocks, items, recipes. 
	//Also registering entities, tileentities, and guiHandlers...
	void addBlocksIngame(){
		
		regBlock(forge, Names.ANVIL_NAME);
		regBlock(lavafurnace, Names.LAVAF_NAME);
		regBlock(bettertable, Names.BETTER_TABLE_NAME);
		regBlock(spiritable, Names.SPIRIT_TABLE_NAME);
		regBlock(driller, Names.DRILLER_NAME);
		regBlock(projecttable, Names.PROJECT_TABLE_NAME);
		regBlock(swissblock, Names.SWISS_TABLE_NAME);
		regBlock(steamfurnace, Names.STEAMF_NAME);
		regBlock(redfurnace, Names.REDF_NAME);
		regBlock(doubleinput, Names.DOUBLEF_NAME);
		regBlock(solarfurnace, Names.SOLARF_NAME);
		regBlock(highspeed, Names.HSPEEDF_NAME);
		regItem(portableCraft, Names.PORT_TABLE_NAME);
		regItem(nail, Names.NAIL_NAME);
		regItem(hammer, Names.HAMMER_NAME);
		regItem(handsaw, Names.HANDSAW_NAME);
		regItem(wrench, Names.WRENCH_NAME);
		regBlock(freezetnt, "Freeze TNT");
		
		
		
		
		
		
	}
	
	void otherRegistries(){
		
		NetworkRegistry.instance().registerGuiHandler(this, this.guiHandler);
		GameRegistry.registerTileEntity(TileEntityHighSpeedFurnace.class, "highSpeed");
		RenderingRegistry.registerBlockHandler(2105, RenderHighSpeed.INSTANCE);
		RenderingRegistry.registerBlockHandler(2106, RenderSteamFurnace.INSTANCE);
		RenderingRegistry.registerBlockHandler(2107, RenderLavaBlock.INSTANCE);
		RenderingRegistry.registerBlockHandler(2108, RenderSolarFurnace.INSTANCE);
		RenderingRegistry.registerBlockHandler(2109, RenderInpBlock.INSTANCE);
		//RenderingRegistry.registerBlockHandler(2010, PipeRender.INSTANCE);
		RenderingRegistry.registerBlockHandler(2111, RenderRedFurnace.INSTANCE);
		GameRegistry.registerTileEntity(TePT.class, "ProjectTableTile");
	
		
	}
	
	void registerRecipes(){
		
		GameRegistry.addRecipe(new ItemStack(portableCraft, 1), new Object[] {"   ", " F ", " C ", Character.valueOf('F'), Item.itemFrame, Character.valueOf('F'), Block.workbench});
		
	}
	
	public void regItem(Item item, String name){
		GameRegistry.registerItem(item, item.getUnlocalizedName());
		LanguageRegistry.addName(item, name);
	}
	
	public void regBlock(Block block, String name){
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
		LanguageRegistry.addName(block, name);
	}
	
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event)
	{
		
	}

}