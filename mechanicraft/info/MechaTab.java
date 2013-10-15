package mechanicraft.info;

import mechanicraft.MechaniCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MechaTab extends CreativeTabs {

	//public static final CreativeTabs tabMechaniCraft = new MechaTab("mechanicraft");

	public MechaTab(String label) {
		super(label);
	}

	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(MechaniCraft.projecttable);
	}

	@Override
	public String getTranslatedTabLabel() {
		return "MechaniCraft";
	}
}