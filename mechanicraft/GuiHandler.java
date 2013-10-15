package mechanicraft;

import mechanicraft.MechaniCraft;
import mechanicraft.container.ContainerAnvilCraft;
import mechanicraft.container.ContainerBetterTable;
import mechanicraft.container.ContainerHighSpeedFurnace;
import mechanicraft.container.ContainerInputFurnace;
import mechanicraft.container.ContainerLavaFurnace;
import mechanicraft.container.ContainerPortTable;
import mechanicraft.container.ContainerProjectTable;
import mechanicraft.container.ContainerSolarFurnace;
import mechanicraft.container.ContainerSpiritTable;
import mechanicraft.container.ContainerSwissCrafting;
import mechanicraft.container.RedContainer;
import mechanicraft.container.SteamContainer;
import mechanicraft.gui.BetterTableGui;
import mechanicraft.gui.GuiAnvilCraft;
import mechanicraft.gui.GuiHighSpeedFurnace;
import mechanicraft.gui.GuiInputFurnace;
import mechanicraft.gui.GuiLavaFurnace;
import mechanicraft.gui.GuiPortTable;
import mechanicraft.gui.GuiSolarFurnace;
import mechanicraft.gui.GuiSpiritTable;
import mechanicraft.gui.ProjectTableGui;
import mechanicraft.gui.RedGui;
import mechanicraft.gui.SteamGui;
import mechanicraft.tileentity.TePT;
import mechanicraft.tileentity.TileEntityHighSpeedFurnace;
import mechanicraft.tileentity.TileEntityInputFurnace;
import mechanicraft.tileentity.TileEntityLavaFurnace;
import mechanicraft.tileentity.TileEntityRedFurnace;
import mechanicraft.tileentity.TileEntitySolarFurnace;
import mechanicraft.tileentity.TileEntitySteamFurnace;
import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		//TePT tile_proj = (TePT)world.getBlockTileEntity(x, y, z);
		switch(id)
		{	
			case 0: return world.getBlockId(x, y, z) == MechaniCraft.forge.blockID ? new ContainerAnvilCraft(player.inventory, world, x, y, z) : null;
			case 1: return world.getBlockId(x, y, z) == MechaniCraft.bettertable.blockID ? new ContainerBetterTable(player.inventory, world, x, y, z) : null;
			case 2: return new ContainerHighSpeedFurnace(player.inventory, (TileEntityHighSpeedFurnace) tile_entity);
			case 3: return new ContainerLavaFurnace(player.inventory, (TileEntityLavaFurnace) tile_entity);	
			case 4: if (ContainerPortTable.canBeWorkbench(player.getHeldItem())) {
		        return new ContainerPortTable(player.inventory, world, x, y, z);
			}
			case 5: return world.getBlockId(x, y, z) == MechaniCraft.projecttable.blockID && tile_entity instanceof TePT ? new ContainerProjectTable((TePT)tile_entity, player.inventory, world, x, y, z) : null;
			case 6: return new RedContainer(player.inventory, (TileEntityRedFurnace) tile_entity);	
			case 7: return new ContainerSolarFurnace(player.inventory, (TileEntitySolarFurnace) tile_entity);
			case 8: return new ContainerSpiritTable(player.inventory, (world), x, y, z);
			case 9: return new SteamContainer(player.inventory, (TileEntitySteamFurnace) tile_entity);	
			case 10: return  world.getBlockId(x, y, z) == MechaniCraft.swissblock.blockID ? new ContainerSwissCrafting(player.inventory, world, x, y, z) : null;
			//case 2: return new ContainerChest(player.inventory, (TileEntityChest) tile_entity);
			case 11: return new ContainerInputFurnace(player.inventory, (TileEntityInputFurnace) tile_entity);
				
		}
		return null;
		
	}
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		
		switch(id)
		{		
			case 0: return world.getBlockId(x, y, z) == MechaniCraft.forge.blockID ? new GuiAnvilCraft(player.inventory, world, x, y, z) : null;
			case 1: return world.getBlockId(x, y, z) == MechaniCraft.bettertable.blockID ? new BetterTableGui(player.inventory, world, x, y, z) : null;
			case 2: return new GuiHighSpeedFurnace(player.inventory, (TileEntityHighSpeedFurnace) tile_entity);
			case 3: return new GuiLavaFurnace(player.inventory, (TileEntityLavaFurnace) tile_entity);		
			case 4: return new GuiPortTable(new ContainerPortTable(player.inventory, world, x, y, z));
			case 5: return world.getBlockId(x, y, z) == MechaniCraft.projecttable.blockID && tile_entity instanceof TePT ? new ProjectTableGui(player.inventory, (TePT)tile_entity, world, x, y, z) : null;
			case 6: return new RedGui(player.inventory, (TileEntityRedFurnace) tile_entity);		
			case 7: return new GuiSolarFurnace(player.inventory, (TileEntitySolarFurnace) tile_entity);
			case 8: return new GuiSpiritTable(player.inventory, (world), x, y, z);
			case 9: return new SteamGui(player.inventory, (TileEntitySteamFurnace) tile_entity);		
			case 10: return world.getBlockId(x, y, z) == MechaniCraft.swissblock.blockID ? new GuiCrafting(player.inventory, world, x, y, z) : null;
			//case 2: return new GuiChest(player.inventory, (TileEntityChest) tile_entity);
			case 11: return new GuiInputFurnace(player.inventory, (TileEntityInputFurnace) tile_entity);
	
			
		}
		return null;
	}	
}