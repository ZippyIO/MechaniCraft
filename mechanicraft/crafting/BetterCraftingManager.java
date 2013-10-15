package mechanicraft.crafting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import mechanicraft.MechaniCraft;
import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class BetterCraftingManager
{
	public static final int WILDCARD_VALUE = Short.MAX_VALUE;
	private static final BetterCraftingManager instance = new BetterCraftingManager();
	private List recipes = new ArrayList();
	
	public static final BetterCraftingManager getInstance()
    {
        return instance;
    }

    private BetterCraftingManager()
    {
    	recipes = new ArrayList();
    	//Basic Crafts
    	this.func_92051_a(new ItemStack(Block.planks, 4, 0), new Object[] {"H#", Character.valueOf('#'), new ItemStack(Block.wood, 1, 0), Character.valueOf('H'), new ItemStack(MechaniCraft.handsaw,1,WILDCARD_VALUE)});
		this.func_92051_a(new ItemStack(Block.planks, 4, 1), new Object[] {"H#", Character.valueOf('#'), new ItemStack(Block.wood, 1, 1), Character.valueOf('H'), new ItemStack(MechaniCraft.handsaw,1,WILDCARD_VALUE)});
		this.func_92051_a(new ItemStack(Block.planks, 4, 2), new Object[] {"H#", Character.valueOf('#'), new ItemStack(Block.wood, 1, 2), Character.valueOf('H'), new ItemStack(MechaniCraft.handsaw,1,WILDCARD_VALUE)});
		this.func_92051_a(new ItemStack(Block.planks, 4, 3), new Object[] {"H#", Character.valueOf('#'), new ItemStack(Block.wood, 1, 3), Character.valueOf('H'), new ItemStack(MechaniCraft.handsaw,1,WILDCARD_VALUE)});
		this.func_92051_a(new ItemStack(Item.stick, 4), new Object[] {"H#", Character.valueOf('#'), Block.planks, Character.valueOf('H'), new ItemStack(MechaniCraft.handsaw,1,WILDCARD_VALUE)});
		this.func_92051_a(new ItemStack(Block.torchWood, 4), new Object[] {"  C  ", "  S  ", Character.valueOf('C'), Item.coal, Character.valueOf('S'), Item.stick});
		this.func_92051_a(new ItemStack(Block.workbench, 1), new Object[] {"HSN", " PP", " PP", Character.valueOf('P'), Block.planks, Character.valueOf('H'), new ItemStack(MechaniCraft.hammer, 1, WILDCARD_VALUE), Character.valueOf('S'), new ItemStack(MechaniCraft.handsaw, 1, WILDCARD_VALUE), Character.valueOf('N'), MechaniCraft.nail});
		this.func_92051_a(new ItemStack(Block.furnaceIdle, 1), new Object[] {"CCC", "C C", "CCC", Character.valueOf('C'), Block.cobblestone});
		this.func_92051_a(new ItemStack(Block.chest, 1), new Object[] {"HSN", "PPP", "P P", "PPP", Character.valueOf('P'), Block.planks, Character.valueOf('H'), new ItemStack(MechaniCraft.hammer, 1, WILDCARD_VALUE), Character.valueOf('S'), new ItemStack(MechaniCraft.handsaw, 1, WILDCARD_VALUE), Character.valueOf('N'), MechaniCraft.nail});
		
		//Ore Blocks
		this.func_92051_a(new ItemStack(Block.blockDiamond, 1), new Object[] {"DDD", "DDD", "DDD", Character.valueOf('D'), Item.diamond});
		this.func_92051_a(new ItemStack(Block.blockGold, 1), new Object[] {"III", "III", "III", Character.valueOf('I'), Item.ingotGold});
		this.func_92051_a(new ItemStack(Block.blockIron, 1), new Object[] {"III", "III", "III", Character.valueOf('I'), Item.ingotIron});
		this.func_92051_a(new ItemStack(Block.blockLapis, 1), new Object[] {"III", "III", "III", Character.valueOf('I'), new ItemStack(Item.dyePowder, 1, 4)});
		this.func_92051_a(new ItemStack(Block.blockRedstone, 1), new Object[] {"III", "III", "III", Character.valueOf('I'), Item.redstone});
		
		//Amor
		//Helmets
		this.func_92051_a(new ItemStack(Item.helmetLeather, 1), new Object[] {"LLL", "L L", Character.valueOf('L'), Item.leather});
		this.func_92051_a(new ItemStack(Item.helmetIron, 1), new Object[] {"III", "I I", Character.valueOf('I'), Item.ingotIron});
		this.func_92051_a(new ItemStack(Item.helmetGold, 1), new Object[] {"GGG", "G G", Character.valueOf('G'), Item.ingotGold});
		this.func_92051_a(new ItemStack(Item.helmetDiamond, 1), new Object[] {"DDD", "D D", Character.valueOf('D'), Item.diamond});
		//this.func_92051_a(new ItemStack(Item.helmetChain, 1), new Object[] {"CCC", "C C", Character.valueOf('C'), Item.diamond});
		
		//ChestPlate
		this.func_92051_a(new ItemStack(Item.plateLeather, 1), new Object[] {"L L", "LLL", "LLL", Character.valueOf('L'), Item.leather});
		this.func_92051_a(new ItemStack(Item.plateIron, 1), new Object[] {"I I", "III", "III", Character.valueOf('I'), Item.ingotIron});
		this.func_92051_a(new ItemStack(Item.plateGold, 1), new Object[] {"G G", "GGG", "GGG", Character.valueOf('G'), Item.ingotGold});
		this.func_92051_a(new ItemStack(Item.plateDiamond, 1), new Object[] {"D D", "DDD", "DDD", Character.valueOf('D'), Item.diamond});
		//this.func_92051_a(new ItemStack(Item.plateChain, 1), new Object[] {"C C", "CCC", "CCC", Character.valueOf('C'), Item.diamond});
		
		//Leggings
		this.func_92051_a(new ItemStack(Item.plateLeather, 1), new Object[] {"LLL", "L L", "L L", Character.valueOf('L'), Item.leather});
		this.func_92051_a(new ItemStack(Item.plateIron, 1), new Object[] {"III", "I I", "I I", Character.valueOf('I'), Item.ingotIron});
		this.func_92051_a(new ItemStack(Item.plateGold, 1), new Object[] {"GGG", "G G", "G G", Character.valueOf('G'), Item.ingotGold});
		this.func_92051_a(new ItemStack(Item.plateDiamond, 1), new Object[] {"DDD", "D D", "D D", Character.valueOf('D'), Item.diamond});
		//this.func_92051_a(new ItemStack(Item.plateChain, 1), new Object[] {"CCC", "C C", "C C", Character.valueOf('C'), Item.diamond});
		
		//Boots
		this.func_92051_a(new ItemStack(Item.bootsLeather, 1), new Object[] {"L L", "L L", Character.valueOf('L'), Item.leather});
		this.func_92051_a(new ItemStack(Item.bootsIron, 1), new Object[] {"I I", "I I", Character.valueOf('I'), Item.ingotIron});
		this.func_92051_a(new ItemStack(Item.bootsGold, 1), new Object[] {"G G", "G G", Character.valueOf('G'), Item.ingotGold});
		this.func_92051_a(new ItemStack(Item.bootsDiamond, 1), new Object[] {"D D", "D D", Character.valueOf('D'), Item.diamond});
		//this.func_92051_a(new ItemStack(Item.bootsChain, 1), new Object[] {"C C", "C C", Character.valueOf('C'), Item.diamond});
		
		//Blocks
		this.func_92051_a(new ItemStack(Block.brick, 1), new Object[] {"BB", "BB", Character.valueOf('B'), Item.brick});
		this.func_92051_a(new ItemStack(Block.blockClay, 1), new Object[] {"CC", "CC", Character.valueOf('C'), Item.clay});
		this.func_92051_a(new ItemStack(Block.glowStone, 1), new Object[] {"GG", "GG", Character.valueOf('G'), Item.glowstone});
		this.func_92051_a(new ItemStack(Block.melon, 1), new Object[] {"MMM", "MMM", "MMM", Character.valueOf('M'), Item.melon});
		this.func_92051_a(new ItemStack(Block.sandStone, 1), new Object[] {"SS", "SS", Character.valueOf('S'), Block.sand});
		this.func_92051_a(new ItemStack(Block.snow, 1), new Object[] {"SS", "SS", Character.valueOf('S'), Item.snowball});
		this.func_92051_a(new ItemStack(Block.stoneBrick, 4), new Object[] {"SS", "SS", Character.valueOf('S'), Block.stone});
		this.func_92051_a(new ItemStack(Block.tnt, 1), new Object[] {"GSG", "SGS", "GSG",Character.valueOf('S'), Block.sand, Character.valueOf('G'), Item.gunpowder});
		this.func_92051_a(new ItemStack(Block.music, 1), new Object[] {"HSN", "PPP", "PRP", "PPP",Character.valueOf('P'), Block.planks, Character.valueOf('R'), Item.redstone, Character.valueOf('H'), new ItemStack(MechaniCraft.hammer, 1, WILDCARD_VALUE), Character.valueOf('S'), new ItemStack(MechaniCraft.handsaw, 1, WILDCARD_VALUE), Character.valueOf('N'), MechaniCraft.nail});
		this.func_92051_a(new ItemStack(Block.stoneSingleSlab, 3, 0), new Object[] {"SSS", Character.valueOf('S'), Block.stone});
		this.func_92051_a(new ItemStack(Block.stoneSingleSlab, 3, 1), new Object[] {"SSS", Character.valueOf('S'), Block.sandStone});
		this.func_92051_a(new ItemStack(Block.stoneSingleSlab, 3, 2), new Object[] {" H ", "SSS", Character.valueOf('S'), Block.planks, Character.valueOf('H'), new ItemStack(MechaniCraft.handsaw,1,WILDCARD_VALUE)});
		this.func_92051_a(new ItemStack(Block.stoneSingleSlab, 3, 3), new Object[] {"SSS", Character.valueOf('S'), Block.cobblestone});
		this.func_92051_a(new ItemStack(Block.stoneSingleSlab, 3, 4), new Object[] {"SSS", Character.valueOf('S'), Block.brick});
		this.func_92051_a(new ItemStack(Block.stoneSingleSlab, 3, 5), new Object[] {"SSS", Character.valueOf('S'), Block.stoneBrick});
		this.func_92051_a(new ItemStack(Block.stoneSingleSlab, 3, 6), new Object[] {"SSS", Character.valueOf('S'), Block.netherBrick});
		this.func_92051_a(new ItemStack(Block.stoneSingleSlab, 3, 7), new Object[] {"SSS", Character.valueOf('S'), Block.blockNetherQuartz});
		this.func_92051_a(new ItemStack(Block.stairsWoodOak, 4), new Object[] {"HCN", "S  ", "SS ", "SSS", Character.valueOf('S'), new ItemStack(Block.planks, 1, 0), Character.valueOf('H'), new ItemStack(MechaniCraft.hammer, 1, WILDCARD_VALUE), Character.valueOf('C'), new ItemStack(MechaniCraft.handsaw, 1, WILDCARD_VALUE), Character.valueOf('N'), MechaniCraft.nail});
		this.func_92051_a(new ItemStack(Block.stairsWoodSpruce, 4), new Object[] {"HCN", "S  ", "SS ", "SSS", Character.valueOf('S'), new ItemStack(Block.planks, 1, 1), Character.valueOf('H'), new ItemStack(MechaniCraft.hammer, 1, WILDCARD_VALUE), Character.valueOf('C'), new ItemStack(MechaniCraft.handsaw, 1, WILDCARD_VALUE), Character.valueOf('N'), MechaniCraft.nail});
		this.func_92051_a(new ItemStack(Block.stairsWoodBirch, 4), new Object[] {"HCN", "S  ", "SS ", "SSS", Character.valueOf('S'), new ItemStack(Block.planks, 1, 2), Character.valueOf('H'), new ItemStack(MechaniCraft.hammer, 1, WILDCARD_VALUE), Character.valueOf('C'), new ItemStack(MechaniCraft.handsaw, 1, WILDCARD_VALUE), Character.valueOf('N'), MechaniCraft.nail});
		this.func_92051_a(new ItemStack(Block.stairsWoodJungle, 4), new Object[] {"HCN", "S  ", "SS ", "SSS", Character.valueOf('S'), new ItemStack(Block.planks, 1, 3), Character.valueOf('H'), new ItemStack(MechaniCraft.hammer, 1, WILDCARD_VALUE), Character.valueOf('C'), new ItemStack(MechaniCraft.handsaw, 1, WILDCARD_VALUE), Character.valueOf('N'), MechaniCraft.nail});
		this.func_92051_a(new ItemStack(Block.stairsCobblestone, 4), new Object[] {"S  ", "SS ", "SSS", Character.valueOf('S'), Block.cobblestone});
		this.func_92051_a(new ItemStack(Block.stairsBrick, 4), new Object[] {"S  ", "SS ", "SSS", Character.valueOf('S'), Block.brick});
		this.func_92051_a(new ItemStack(Block.stairsStoneBrick, 4), new Object[] {"S  ", "SS ", "SSS", Character.valueOf('S'), Block.stoneBrick});
		this.func_92051_a(new ItemStack(Block.stairsNetherBrick, 4), new Object[] {"S  ", "SS ", "SSS", Character.valueOf('S'), Block.netherBrick});
		this.func_92051_a(new ItemStack(Block.stairsNetherQuartz, 4), new Object[] {"S  ", "SS ", "SSS", Character.valueOf('S'), Block.blockNetherQuartz});
		this.func_92051_a(new ItemStack(Block.dispenser, 1), new Object[] {"CCC", "CBC", "CRC", Character.valueOf('C'), Block.cobblestone, Character.valueOf('B'), Item.bow, Character.valueOf('R'), Item.redstone});
		this.func_92051_a(new ItemStack(Block.enchantmentTable, 1), new Object[] {" B ", "DOD", "DDD", Character.valueOf('B'), Item.book, Character.valueOf('D'), Item.diamond, Character.valueOf('O'), Block.obsidian});
		this.func_92051_a(new ItemStack(Block.pistonBase, 1), new Object[] {"PPP", "CIC", "CRC", Character.valueOf('P'), Block.planks, Character.valueOf('C'), Block.cobblestone, Character.valueOf('I'), Item.ingotIron, Character.valueOf('R'), Item.redstone});
		this.func_92051_a(new ItemStack(Block.jukebox, 1), new Object[] {"HSN", "PPP", "PDP", "PPP", Character.valueOf('P'), Block.planks, Character.valueOf('D'), Item.diamond, Character.valueOf('H'), new ItemStack(MechaniCraft.hammer, 1, WILDCARD_VALUE), Character.valueOf('S'), new ItemStack(MechaniCraft.handsaw, 1, WILDCARD_VALUE), Character.valueOf('N'), MechaniCraft.nail});
		
		//Misc
		this.func_92051_a(new ItemStack(Item.bed, 1), new Object[] {"HSN", "WWW", "PPP", Character.valueOf('P'), Block.planks, Character.valueOf('W'), new ItemStack(Block.cloth, 1, 0), Character.valueOf('H'), new ItemStack(MechaniCraft.hammer, 1, WILDCARD_VALUE), Character.valueOf('S'), new ItemStack(MechaniCraft.handsaw, 1, WILDCARD_VALUE), Character.valueOf('N'), MechaniCraft.nail});
		this.func_92051_a(new ItemStack(Block.bookShelf, 1), new Object[] {" H ", "PPP", "BBB", "PPP", Character.valueOf('P'), Block.planks, Character.valueOf('B'), Item.book, Character.valueOf('H'), new ItemStack(MechaniCraft.handsaw,1,WILDCARD_VALUE)});
		this.func_92051_a(new ItemStack(Item.doorWood, 1), new Object[] {"PP ","PPH", "PP ", Character.valueOf('P'), Block.planks, Character.valueOf('H'), new ItemStack(MechaniCraft.handsaw,1,WILDCARD_VALUE)});
		this.func_92051_a(new ItemStack(Item.doorIron, 1), new Object[] {"II", "II", "II", Character.valueOf('I'), Item.ingotIron});
		this.func_92051_a(new ItemStack(Block.netherFence, 6), new Object[] {"NNN", "NNN", Character.valueOf('N'), Block.netherBrick});
		this.func_92051_a(new ItemStack(Block.fence, 2), new Object[] {" H ", "SSS", "SSS", Character.valueOf('S'), Item.stick, Character.valueOf('H'), new ItemStack(MechaniCraft.handsaw,1,WILDCARD_VALUE)});
		this.func_92051_a(new ItemStack(Block.fenceGate, 1), new Object[] {" H ", "SPS", "SPS", Character.valueOf('S'), Item.stick, Character.valueOf('P'), Block.planks, Character.valueOf('H'), new ItemStack(MechaniCraft.handsaw,1,WILDCARD_VALUE)});
		this.func_92051_a(new ItemStack(Block.thinGlass, 16), new Object[] {"GGG", "GGG", Character.valueOf('G'), Block.glass});
		this.func_92051_a(new ItemStack(Block.fenceIron, 16), new Object[] {"III", "III", Character.valueOf('I'), Item.ingotIron});
		this.func_92051_a(new ItemStack(Block.pumpkinLantern, 1), new Object[] {"P", "T", Character.valueOf('P'), Block.pumpkin, Character.valueOf('T'), Block.torchWood});
		this.func_92051_a(new ItemStack(Block.ladder, 2), new Object[] {" H ", "S S", "SSS", "S S", Character.valueOf('S'), Item.stick, Character.valueOf('H'), new ItemStack(MechaniCraft.handsaw,1,WILDCARD_VALUE)});
		this.func_92051_a(new ItemStack(Item.painting, 1), new Object[] {" H ", "SSS", "SWS", "SSS",Character.valueOf('S'), Item.stick, Character.valueOf('W'), new ItemStack(Block.cloth, 1, 0), Character.valueOf('H'), new ItemStack(MechaniCraft.handsaw,1,WILDCARD_VALUE)});
		this.func_92051_a(new ItemStack(Item.sign, 1), new Object[] {"HCN", "PPP", "PPP", " S ",Character.valueOf('P'), Block.planks, Character.valueOf('S'), Item.stick, Character.valueOf('H'), new ItemStack(MechaniCraft.hammer, 1, WILDCARD_VALUE), Character.valueOf('C'), new ItemStack(MechaniCraft.handsaw, 1, WILDCARD_VALUE), Character.valueOf('N'), MechaniCraft.nail});
		this.func_92051_a(new ItemStack(Item.dyePowder, 3, 15), new Object[] {"B", Character.valueOf('B'), Item.bone});
		this.func_92051_a(new ItemStack(Item.dyePowder, 2, 6), new Object[] {"G L", Character.valueOf('G'), new ItemStack(Item.dyePowder, 1, 2), Character.valueOf('L'), new ItemStack(Item.dyePowder, 1, 4)});
		this.func_92051_a(new ItemStack(Item.dyePowder, 2, 11), new Object[] {"Y", Character.valueOf('Y'), Block.plantYellow});
		this.func_92051_a(new ItemStack(Item.dyePowder, 2, 8), new Object[] {"B I", Character.valueOf('B'), new ItemStack(Item.dyePowder, 1, 15), Character.valueOf('I'), new ItemStack(Item.dyePowder, 1, 0)});
		this.func_92051_a(new ItemStack(Item.dyePowder, 2, 12), new Object[] {"B L", Character.valueOf('B'), new ItemStack(Item.dyePowder, 1, 15), Character.valueOf('L'), new ItemStack(Item.dyePowder, 1, 4)});
		this.func_92051_a(new ItemStack(Item.dyePowder, 2, 7), new Object[] {"B G", Character.valueOf('B'), new ItemStack(Item.dyePowder, 1, 15), Character.valueOf('G'), new ItemStack(Item.dyePowder, 1, 8)});
		this.func_92051_a(new ItemStack(Item.dyePowder, 2, 7), new Object[] {"BIB", Character.valueOf('B'), new ItemStack(Item.dyePowder, 1, 15), Character.valueOf('I'), new ItemStack(Item.dyePowder, 1, 0)});
		this.func_92051_a(new ItemStack(Item.dyePowder, 2, 10), new Object[] {"G B", Character.valueOf('G'), new ItemStack(Item.dyePowder, 1, 2), Character.valueOf('B'), new ItemStack(Item.dyePowder, 1, 15)});
		this.func_92051_a(new ItemStack(Item.dyePowder, 3, 13), new Object[] {"P H", Character.valueOf('P'), new ItemStack(Item.dyePowder, 1, 9), Character.valueOf('H'), new ItemStack(Item.dyePowder, 1, 5)});
		this.func_92051_a(new ItemStack(Item.dyePowder, 2, 14), new Object[] {"Y R", Character.valueOf('Y'), new ItemStack(Item.dyePowder, 1, 11), Character.valueOf('R'), new ItemStack(Item.dyePowder, 1, 1)});
		this.func_92051_a(new ItemStack(Item.dyePowder, 2, 9), new Object[] {"R B", Character.valueOf('R'), new ItemStack(Item.dyePowder, 1, 1), Character.valueOf('B'), new ItemStack(Item.dyePowder, 1, 15)});
		this.func_92051_a(new ItemStack(Item.dyePowder, 2, 5), new Object[] {"L R", Character.valueOf('L'), new ItemStack(Item.dyePowder, 1, 4), Character.valueOf('R'), new ItemStack(Item.dyePowder, 1, 1)});
		this.func_92051_a(new ItemStack(Item.dyePowder, 2, 1), new Object[] {"R", Character.valueOf('R'), Block.plantRed});
		
		this.func_92051_a(new ItemStack(Item.bowlEmpty, 4), new Object[] {" H ", "P P", " P ", Character.valueOf('P'), Block.planks, Character.valueOf('H'), new ItemStack(MechaniCraft.handsaw,1,WILDCARD_VALUE)});
		this.func_92051_a(new ItemStack(Item.bread, 1), new Object[] {"WWW", Character.valueOf('W'), Item.wheat});
		this.func_92051_a(new ItemStack(Item.cake, 1), new Object[] {"MMM", "SES", "WWW", Character.valueOf('M'), Item.bucketMilk, Character.valueOf('S'), Item.sugar, Character.valueOf('E'), Item.egg, Character.valueOf('W'), Item.wheat});
		this.func_92051_a(new ItemStack(Item.cookie, 8), new Object[] {"WCW", Character.valueOf('W'), Item.wheat, Character.valueOf('C'), new ItemStack(Item.dyePowder, 1, 3)});
		this.func_92051_a(new ItemStack(Item.appleGold, 1), new Object[] {"GGG", "GAG", "GGG", Character.valueOf('G'), Block.blockGold, Character.valueOf('A'), Item.appleRed});
		this.func_92051_a(new ItemStack(Item.melonSeeds, 1), new Object[] {"W", Character.valueOf('W'), Item.melon});
		this.func_92051_a(new ItemStack(Item.pumpkinSeeds, 1), new Object[] {"P", Character.valueOf('P'), Block.pumpkin});
		this.func_92051_a(new ItemStack(Item.sugar, 1), new Object[] {"R", Character.valueOf('R'), Item.reed});
		this.func_92051_a(new ItemStack(Item.ingotGold, 1), new Object[] {"GGG", "GGG", "GGG", Character.valueOf('G'), Item.goldNugget});
		this.func_92051_a(new ItemStack(Item.blazePowder, 2), new Object[] {"B", Character.valueOf('B'), Item.blazeRod});
		this.func_92051_a(new ItemStack(Item.book, 1), new Object[] {"P", "P", "P", Character.valueOf('P'), Item.paper});
		this.func_92051_a(new ItemStack(Block.brewingStand, 1), new Object[] {" B ", "CCC", Character.valueOf('B'), Item.blazeRod, Character.valueOf('C'), Block.cobblestone});
		this.func_92051_a(new ItemStack(Block.cauldron, 1), new Object[] {"I I", "I I", "III", Character.valueOf('I'), Item.ingotIron});
		this.func_92051_a(new ItemStack(Item.eyeOfEnder, 1), new Object[] {"B", "E", Character.valueOf('B'), Item.blazePowder, Character.valueOf('E'), Item.enderPearl});
		this.func_92051_a(new ItemStack(Item.fermentedSpiderEye, 1), new Object[] {"E ", "BS", Character.valueOf('E'), Item.spiderEye, Character.valueOf('B'), Block.mushroomBrown, Character.valueOf('S'), Item.sugar});
		this.func_92051_a(new ItemStack(Item.glassBottle, 3), new Object[] {"G G", " G ", Character.valueOf('G'), Block.glass});
		this.func_92051_a(new ItemStack(Item.magmaCream, 1), new Object[] {"S", "B", Character.valueOf('S'), Item.slimeBall, Character.valueOf('B'), Item.blazePowder});
		this.func_92051_a(new ItemStack(Item.paper, 3), new Object[] {"RRR", Character.valueOf('R'), Item.reed});
		this.func_92051_a(new ItemStack(Block.lever, 1), new Object[] {"S", "C", Character.valueOf('S'), Item.stick, Character.valueOf('C'), Block.cobblestone});
		this.func_92051_a(new ItemStack(Block.pistonStickyBase, 1), new Object[] {"S", "P", Character.valueOf('P'), Block.pistonBase, Character.valueOf('S'), Item.slimeBall});
		this.func_92051_a(new ItemStack(Block.pressurePlateStone, 1), new Object[] {"SS", Character.valueOf('S'), Block.stone});
		this.func_92051_a(new ItemStack(Block.pressurePlatePlanks, 1), new Object[] {" H", "PP", Character.valueOf('P'), Block.planks, Character.valueOf('H'), new ItemStack(MechaniCraft.handsaw,1,WILDCARD_VALUE)});
		this.func_92051_a(new ItemStack(Block.pressurePlateGold, 1), new Object[] {"GG", Character.valueOf('G'), Item.ingotGold});
		this.func_92051_a(new ItemStack(Block.pressurePlateIron, 1), new Object[] {"II", Character.valueOf('I'), Item.ingotIron});
		this.func_92051_a(new ItemStack(Item.redstoneRepeater, 1), new Object[] {"TRT", "SSS", Character.valueOf('S'), Block.stone, Character.valueOf('T'), Block.torchRedstoneActive, Character.valueOf('R'), Item.redstone});
		this.func_92051_a(new ItemStack(Block.stoneButton, 3), new Object[] {"S", "S", Character.valueOf('S'), Block.stone});
		this.func_92051_a(new ItemStack(Block.woodenButton, 3), new Object[] {" P", "HP", Character.valueOf('P'), Block.planks, Character.valueOf('H'), new ItemStack(MechaniCraft.handsaw,1,WILDCARD_VALUE)});
		this.func_92051_a(new ItemStack(Block.torchRedstoneActive, 1), new Object[] {"R", "S", Character.valueOf('S'), Item.stick, Character.valueOf('R'), Item.redstone});
		this.func_92051_a(new ItemStack(Item.axeDiamond, 1), new Object[] {"DD", "DS ", " S", Character.valueOf('S'), Item.stick, Character.valueOf('D'), Item.diamond});
		this.func_92051_a(new ItemStack(Item.axeGold, 1), new Object[] {"GG", "GS", " S", Character.valueOf('S'), Item.stick, Character.valueOf('G'), Item.ingotGold});
		this.func_92051_a(new ItemStack(Item.axeIron, 1), new Object[] {"II", "IS", " S", Character.valueOf('S'), Item.stick, Character.valueOf('I'), Item.ingotIron});
		this.func_92051_a(new ItemStack(Item.axeStone), new Object[] {"CC", "CS", " S", Character.valueOf('S'), Item.stick, Character.valueOf('C'), Block.cobblestone});
		this.func_92051_a(new ItemStack(Item.axeWood, 1), new Object[] {"PP", "PS", " S", Character.valueOf('S'), Item.stick, Character.valueOf('P'), Block.planks});
		this.func_92051_a(new ItemStack(Item.bucketEmpty, 1), new Object[] {"I I", " I ", Character.valueOf('I'), Item.ingotIron});
		this.func_92051_a(new ItemStack(Item.pocketSundial, 1), new Object[] {" G ", "GRG", " G ", Character.valueOf('G'), Item.ingotGold, Character.valueOf('R'), Item.redstone});
		this.func_92051_a(new ItemStack(Item.compass, 1), new Object[] {" I ", "IRI", " I ", Character.valueOf('I'), Item.ingotIron, Character.valueOf('R'), Item.redstone});
		this.func_92051_a(new ItemStack(Item.fishingRod, 1), new Object[] {"  S", " ST", "SHT", Character.valueOf('S'), Item.stick, Character.valueOf('T'), Item.silk, Character.valueOf('H'), new ItemStack(MechaniCraft.handsaw,1,WILDCARD_VALUE)});
		this.func_92051_a(new ItemStack(Item.flintAndSteel, 1), new Object[] {"I  ", " F ", Character.valueOf('I'), Item.ingotIron, Character.valueOf('F'), Item.flint});
		this.func_92051_a(new ItemStack(Item.hoeDiamond, 1), new Object[] {"DD", " S", " S",Character.valueOf('D'), Item.diamond, Character.valueOf('S'), Item.stick});
		this.func_92051_a(new ItemStack(Item.hoeGold, 1), new Object[] {"GG", " S", " S", Character.valueOf('G'), Item.ingotGold, Character.valueOf('S'), Item.stick});
		this.func_92051_a(new ItemStack(Item.hoeIron, 1), new Object[] {"II", " S", " S", Character.valueOf('I'), Item.ingotIron, Character.valueOf('S'), Item.stick});
		this.func_92051_a(new ItemStack(Item.hoeStone, 1), new Object[] {"TT", " S", " S", Character.valueOf('T'), Block.stone, Character.valueOf('S'), Item.stick});
		this.func_92051_a(new ItemStack(Item.hoeWood, 1), new Object[] {"PP", " S", " S", Character.valueOf('S'), Item.stick, Character.valueOf('P'), Block.planks});
		this.func_92051_a(new ItemStack(Item.map, 1), new Object[] {"PPP", "PCP", "PPP", Character.valueOf('P'), Item.paper, Character.valueOf('C'), Item.compass});
		this.func_92051_a(new ItemStack(Item.pickaxeDiamond, 1), new Object[] {"DDD", " S ", " S ", Character.valueOf('S'), Item.stick, Character.valueOf('D'), Item.diamond});
		this.func_92051_a(new ItemStack(Item.pickaxeGold, 1), new Object[] {"GGG", " S ", " S ", Character.valueOf('S'), Item.stick, Character.valueOf('G'), Item.ingotGold});
		this.func_92051_a(new ItemStack(Item.pickaxeIron, 1), new Object[] {"III", " S ", " S ", Character.valueOf('S'), Item.stick, Character.valueOf('I'), Item.ingotIron});
		this.func_92051_a(new ItemStack(Item.pickaxeStone, 1), new Object[] {"CCC", " S ", " S ", Character.valueOf('S'), Item.stick, Character.valueOf('C'), Block.stone});
		this.func_92051_a(new ItemStack(Item.pickaxeWood, 1), new Object[] {"PPP", " S ", " S ", Character.valueOf('S'), Item.stick, Character.valueOf('P'), Block.planks});
		this.func_92051_a(new ItemStack(Item.shears, 1), new Object[] {" I", "I ", Character.valueOf('I'), Item.ingotIron});
		this.func_92051_a(new ItemStack(Item.shovelDiamond, 1), new Object[] {"D", "S", "S", Character.valueOf('S'), Item.stick, Character.valueOf('D'), Item.diamond});
		this.func_92051_a(new ItemStack(Item.shovelGold, 1), new Object[] {"G", "S", "S", Character.valueOf('S'), Item.stick, Character.valueOf('G'), Item.ingotGold});
		this.func_92051_a(new ItemStack(Item.shovelIron, 1), new Object[] {"I", "S", "S", Character.valueOf('S'), Item.stick, Character.valueOf('I'), Item.ingotIron});
		this.func_92051_a(new ItemStack(Item.shovelStone, 1), new Object[] {"C", "S", "S", Character.valueOf('S'), Item.stick, Character.valueOf('C'), Block.stone});
		this.func_92051_a(new ItemStack(Item.shovelWood, 1), new Object[] {"P", "S", "S", Character.valueOf('S'), Item.stick, Character.valueOf('P'), Block.planks});
		this.func_92051_a(new ItemStack(Item.boat, 1), new Object[] {"HSN", "P P", "PPP", Character.valueOf('P'), Block.planks, Character.valueOf('H'), new ItemStack(MechaniCraft.hammer, 1, WILDCARD_VALUE), Character.valueOf('S'), new ItemStack(MechaniCraft.handsaw, 1, WILDCARD_VALUE), Character.valueOf('N'), MechaniCraft.nail});
		this.func_92051_a(new ItemStack(Block.railDetector, 6), new Object[] {"S  ", "SS ", "SSS", Character.valueOf('S'), new ItemStack(Block.wood, 1, 2)});
		this.func_92051_a(new ItemStack(Item.minecartEmpty, 1), new Object[] {"I I", "III", Character.valueOf('I'), Item.ingotIron});
		this.func_92051_a(new ItemStack(Item.minecartCrate, 1), new Object[] {"C", "M", Character.valueOf('C'), Block.chest, Character.valueOf('M'), Item.minecartEmpty});
		this.func_92051_a(new ItemStack(Item.minecartPowered, 1), new Object[] {"F", "M", Character.valueOf('F'), Block.furnaceIdle, Character.valueOf('M'), Item.minecartEmpty});
		this.func_92051_a(new ItemStack(Block.railPowered, 6), new Object[] {"G G", "GSG", "GRG", Character.valueOf('G'), Item.ingotGold, Character.valueOf('S'), Item.stick, Character.valueOf('R'), Item.redstone});
		this.func_92051_a(new ItemStack(Block.rail, 16), new Object[] {"I I", "ISI", "I I", Character.valueOf('S'), Item.stick, Character.valueOf('I'), Item.ingotIron});
		this.func_92051_a(new ItemStack(Item.arrow, 4), new Object[] {"F", "S", "E", Character.valueOf('S'), Item.stick, Character.valueOf('F'), Item.flint, Character.valueOf('E'), Item.feather});
		this.func_92051_a(new ItemStack(Item.bow, 1), new Object[] {" ST", "S T", " ST", Character.valueOf('S'), Item.stick, Character.valueOf('T'), Item.silk});
		this.func_92051_a(new ItemStack(Item.swordDiamond, 1), new Object[] {"D", "D", "S", Character.valueOf('D'), Item.diamond, Character.valueOf('S'), Item.stick});
		this.func_92051_a(new ItemStack(Item.swordGold, 1), new Object[] {"G", "G", "S", Character.valueOf('G'), Item.ingotGold, Character.valueOf('S'), Item.stick});
		this.func_92051_a(new ItemStack(Item.swordIron, 1), new Object[] {"I", "I", "S", Character.valueOf('I'), Item.ingotIron, Character.valueOf('S'), Item.stick});
		this.func_92051_a(new ItemStack(Item.swordStone, 1), new Object[] {"C", "C", "S", Character.valueOf('C'), Block.stone, Character.valueOf('S'), Item.stick});
		this.func_92051_a(new ItemStack(Item.swordWood, 1), new Object[] {"P", "P", "S", Character.valueOf('P'), Block.planks, Character.valueOf('S'), Item.stick});
		this.func_92051_a(new ItemStack(Block.cloth, 1, 0), new Object[] {"SS", "SS", Character.valueOf('S'), Item.silk});
		this.func_92051_a(new ItemStack(Block.cloth, 1, 1), new Object[] {"W I", Character.valueOf('W'), new ItemStack(Block.cloth, 1, 0), Character.valueOf('I'), new ItemStack(Item.dyePowder, 1, 14)});
		this.func_92051_a(new ItemStack(Block.cloth, 1, 2), new Object[] {"W I", Character.valueOf('W'), new ItemStack(Block.cloth, 1, 0), Character.valueOf('I'), new ItemStack(Item.dyePowder, 1, 13)});
		this.func_92051_a(new ItemStack(Block.cloth, 1, 3), new Object[] {"W I", Character.valueOf('W'), new ItemStack(Block.cloth, 1, 0), Character.valueOf('I'), new ItemStack(Item.dyePowder, 1, 12)});
		this.func_92051_a(new ItemStack(Block.cloth, 1, 4), new Object[] {"W I", Character.valueOf('W'), new ItemStack(Block.cloth, 1, 0), Character.valueOf('I'), new ItemStack(Item.dyePowder, 1, 11)});
		this.func_92051_a(new ItemStack(Block.cloth, 1, 5), new Object[] {"W I", Character.valueOf('W'), new ItemStack(Block.cloth, 1, 0), Character.valueOf('I'), new ItemStack(Item.dyePowder, 1, 10)});
		this.func_92051_a(new ItemStack(Block.cloth, 1, 6), new Object[] {"W I", Character.valueOf('W'), new ItemStack(Block.cloth, 1, 0), Character.valueOf('I'), new ItemStack(Item.dyePowder, 1, 9)});
		this.func_92051_a(new ItemStack(Block.cloth, 1, 7), new Object[] {"W I", Character.valueOf('W'), new ItemStack(Block.cloth, 1, 0), Character.valueOf('I'), new ItemStack(Item.dyePowder, 1, 8)});
		this.func_92051_a(new ItemStack(Block.cloth, 1, 8), new Object[] {"W I", Character.valueOf('W'), new ItemStack(Block.cloth, 1, 0), Character.valueOf('I'), new ItemStack(Item.dyePowder, 1, 7)});
		this.func_92051_a(new ItemStack(Block.cloth, 1, 9), new Object[] {"W I", Character.valueOf('W'), new ItemStack(Block.cloth, 1, 0), Character.valueOf('I'), new ItemStack(Item.dyePowder, 1, 6)});
		this.func_92051_a(new ItemStack(Block.cloth, 1, 10), new Object[] {"W I", Character.valueOf('W'), new ItemStack(Block.cloth, 1, 0), Character.valueOf('I'), new ItemStack(Item.dyePowder, 1, 5)});
		this.func_92051_a(new ItemStack(Block.cloth, 1, 11), new Object[] {"W I", Character.valueOf('W'), new ItemStack(Block.cloth, 1, 0), Character.valueOf('I'), new ItemStack(Item.dyePowder, 1, 4)});
		this.func_92051_a(new ItemStack(Block.cloth, 1, 12), new Object[] {"W I", Character.valueOf('W'), new ItemStack(Block.cloth, 1, 0), Character.valueOf('I'), new ItemStack(Item.dyePowder, 1, 3)});
		this.func_92051_a(new ItemStack(Block.cloth, 1, 13), new Object[] {"W I", Character.valueOf('W'), new ItemStack(Block.cloth, 1, 0), Character.valueOf('I'), new ItemStack(Item.dyePowder, 1, 2)});
		this.func_92051_a(new ItemStack(Block.cloth, 1, 14), new Object[] {"W I", Character.valueOf('W'), new ItemStack(Block.cloth, 1, 0), Character.valueOf('I'), new ItemStack(Item.dyePowder, 1, 1)});
		this.func_92051_a(new ItemStack(Block.cloth, 1, 15), new Object[] {"W I", Character.valueOf('W'), new ItemStack(Block.cloth, 1, 0), Character.valueOf('I'), new ItemStack(Item.dyePowder, 1, 0)});
		
		Collections.sort(this.recipes, new BetterRecipeSorter(this));
        System.out.println(this.recipes.size() + " recipes");
    }

    public BetterShapedRecipes func_92051_a(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
    {
        String var3 = "";
        int var4 = 0;
        int var5 = 0;
        int var6 = 0;

        if (par2ArrayOfObj[var4] instanceof String[])
        {
            String[] var7 = (String[])((String[])par2ArrayOfObj[var4++]);

            for (int var8 = 0; var8 < var7.length; ++var8)
            {
                String var9 = var7[var8];
                ++var6;
                var5 = var9.length();
                var3 = var3 + var9;
            }
        }
        else
        {
            while (par2ArrayOfObj[var4] instanceof String)
            {
                String var11 = (String)par2ArrayOfObj[var4++];
                ++var6;
                var5 = var11.length();
                var3 = var3 + var11;
            }
        }

        HashMap var12;

        for (var12 = new HashMap(); var4 < par2ArrayOfObj.length; var4 += 2)
        {
            Character var13 = (Character)par2ArrayOfObj[var4];
            ItemStack var14 = null;

            if (par2ArrayOfObj[var4 + 1] instanceof Item)
            {
                var14 = new ItemStack((Item)par2ArrayOfObj[var4 + 1]);
            }
            else if (par2ArrayOfObj[var4 + 1] instanceof Block)
            {
                var14 = new ItemStack((Block)par2ArrayOfObj[var4 + 1], 1, -1);
            }
            else if (par2ArrayOfObj[var4 + 1] instanceof ItemStack)
            {
                var14 = (ItemStack)par2ArrayOfObj[var4 + 1];
            }

            var12.put(var13, var14);
        }

        ItemStack[] var15 = new ItemStack[var5 * var6];

        for (int var16 = 0; var16 < var5 * var6; ++var16)
        {
            char var10 = var3.charAt(var16);

            if (var12.containsKey(Character.valueOf(var10)))
            {
                var15[var16] = ((ItemStack)var12.get(Character.valueOf(var10))).copy();
            }
            else
            {
                var15[var16] = null;
            }
        }

        BetterShapedRecipes var17 = new BetterShapedRecipes(var5, var6, var15, par1ItemStack);
        this.recipes.add(var17);
        return var17;
    }

    public void addBuilderShapelessRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
    {
        ArrayList var3 = new ArrayList();
        Object[] var4 = par2ArrayOfObj;
        int var5 = par2ArrayOfObj.length;

        for (int var6 = 0; var6 < var5; ++var6)
        {
            Object var7 = var4[var6];

            if (var7 instanceof ItemStack)
            {
                var3.add(((ItemStack)var7).copy());
            }
            else if (var7 instanceof Item)
            {
                var3.add(new ItemStack((Item)var7));
            }
            else
            {
                if (!(var7 instanceof Block))
                {
                    throw new RuntimeException("Invalid shapeless recipy!");
                }

                var3.add(new ItemStack((Block)var7));
            }
        }

        this.recipes.add(new BetterShapelessRecipes(par1ItemStack, var3));
    }

    public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, World par2World)
    {
        int var3 = 0;
        ItemStack var4 = null;
        ItemStack var5 = null;
        int var6;

        for (var6 = 0; var6 < par1InventoryCrafting.getSizeInventory(); ++var6)
        {
            ItemStack var7 = par1InventoryCrafting.getStackInSlot(var6);

            if (var7 != null)
            {
                if (var3 == 0)
                {
                    var4 = var7;
                }

                if (var3 == 1)
                {
                    var5 = var7;
                }

                ++var3;
            }
        }

        if (var3 == 2 && var4.itemID == var5.itemID && var4.stackSize == 1 && var5.stackSize == 1 && Item.itemsList[var4.itemID].isRepairable())
        {
            Item var11 = Item.itemsList[var4.itemID];
            int var13 = var11.getMaxDamage() - var4.getItemDamageForDisplay();
            int var8 = var11.getMaxDamage() - var5.getItemDamageForDisplay();
            int var9 = var13 + var8 + var11.getMaxDamage() * 5 / 100;
            int var10 = var11.getMaxDamage() - var9;

            if (var10 < 0)
            {
                var10 = 0;
            }

            return new ItemStack(var4.itemID, 1, var10);
        }
        else
        {
            for (var6 = 0; var6 < this.recipes.size(); ++var6)
            {
                IRecipe var12 = (IRecipe)this.recipes.get(var6);

                if (var12.matches(par1InventoryCrafting, par2World))
                {
                    return var12.getCraftingResult(par1InventoryCrafting);
                }
            }

            return null;
        }
    }

    /**
     * returns the List<> of all recipes
     */
    public List getRecipeList()
    {
        return this.recipes;
    }
}