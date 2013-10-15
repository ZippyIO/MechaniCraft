package mechanicraft.crafting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class SpiritCraftingManager
{
	public static final int WILDCARD_VALUE = Short.MAX_VALUE;
	
    /** The static instance of this class */
    private static final SpiritCraftingManager instance = new SpiritCraftingManager();

    /** A list of all the recipes added */
    private List recipes = new ArrayList();

    /**
     * Returns the static instance of this class
     */
    public static final SpiritCraftingManager getInstance()
    {
        return instance;
    }

    private SpiritCraftingManager()
    {
    	recipes = new ArrayList();
    	//Tools Unbreaking
		ItemStack shears = new ItemStack(Item.shears);
		shears.addEnchantment(Enchantment.unbreaking, 3);
		shears.hasEffect();
		this.func_92051_a(shears, new Object[] {"II", "SB", Character.valueOf('I'), Item.ingotIron, Character.valueOf('S'), Item.shears, Character.valueOf('B'), Item.blazePowder});
		ItemStack fishingRod = new ItemStack(Item.fishingRod);
		fishingRod.addEnchantment(Enchantment.unbreaking, 3);
		fishingRod.hasEffect();
		this.func_92051_a(fishingRod, new Object[] {"II", "SB", Character.valueOf('I'), Item.ingotIron, Character.valueOf('S'), Item.fishingRod, Character.valueOf('B'), Item.blazePowder});
		ItemStack flintandSteel = new ItemStack(Item.flintAndSteel);
		flintandSteel.addEnchantment(Enchantment.unbreaking, 3);
		flintandSteel.hasEffect();
		this.func_92051_a(flintandSteel, new Object[] {"II", "SB", Character.valueOf('I'), Item.ingotIron, Character.valueOf('S'), Item.flintAndSteel, Character.valueOf('B'), Item.blazePowder});
		ItemStack carrotStick = new ItemStack(Item.carrotOnAStick);
		carrotStick.addEnchantment(Enchantment.unbreaking, 3);
		carrotStick.hasEffect();
		this.func_92051_a(carrotStick, new Object[] {"II", "SB", Character.valueOf('I'), Item.ingotIron, Character.valueOf('S'), Item.carrotOnAStick, Character.valueOf('B'), Item.blazePowder});
		ItemStack goldHoe = new ItemStack(Item.hoeGold);
		goldHoe.addEnchantment(Enchantment.unbreaking, 3);
		goldHoe.hasEffect();
		this.func_92051_a(goldHoe, new Object[] {"DD", "SB", Character.valueOf('D'), Item.diamond, Character.valueOf('S'), Item.hoeGold, Character.valueOf('B'), Item.ghastTear});
		ItemStack goldSpade = new ItemStack(Item.shovelGold);
		goldSpade.addEnchantment(Enchantment.unbreaking, 3);
		goldSpade.hasEffect();
		this.func_92051_a(goldSpade, new Object[] {"DD", "SB", Character.valueOf('D'), Item.diamond, Character.valueOf('S'), Item.shovelGold, Character.valueOf('B'), Item.ghastTear});
		ItemStack goldAxe = new ItemStack(Item.axeGold);
		goldAxe.addEnchantment(Enchantment.unbreaking, 3);
		goldAxe.hasEffect();
		this.func_92051_a(goldAxe, new Object[] {"DD", "SB", Character.valueOf('D'), Item.diamond, Character.valueOf('S'), Item.axeGold, Character.valueOf('B'), Item.ghastTear});
		ItemStack goldPickAxe = new ItemStack(Item.pickaxeGold);
		goldPickAxe.addEnchantment(Enchantment.unbreaking, 3);
		goldPickAxe.hasEffect();
		this.func_92051_a(goldPickAxe, new Object[] {"DD", "SB", Character.valueOf('D'), Item.diamond, Character.valueOf('S'), Item.pickaxeGold, Character.valueOf('B'), Item.ghastTear});
		ItemStack diamondHoe = new ItemStack(Item.hoeDiamond);
		diamondHoe.addEnchantment(Enchantment.unbreaking, 3);
		diamondHoe.hasEffect();
		this.func_92051_a(diamondHoe, new Object[] {"EE", "SB", Character.valueOf('E'), Item.emerald, Character.valueOf('S'), Item.hoeDiamond, Character.valueOf('B'), Item.ghastTear});
		ItemStack diamondSpade = new ItemStack(Item.shovelDiamond);
		diamondSpade.addEnchantment(Enchantment.unbreaking, 3);
		diamondSpade.hasEffect();
		this.func_92051_a(diamondSpade, new Object[] {"EE", "SB", Character.valueOf('E'), Item.emerald, Character.valueOf('S'), Item.shovelDiamond, Character.valueOf('B'), Item.ghastTear});
		ItemStack diamondAxe = new ItemStack(Item.axeDiamond);
		diamondAxe.addEnchantment(Enchantment.unbreaking, 3);
		diamondAxe.hasEffect();
		this.func_92051_a(diamondAxe, new Object[] {"EE", "SB", Character.valueOf('E'), Item.emerald, Character.valueOf('S'), Item.axeDiamond, Character.valueOf('B'), Item.ghastTear});
		ItemStack diamondPickAxe = new ItemStack(Item.pickaxeDiamond);
		diamondPickAxe.addEnchantment(Enchantment.unbreaking, 3);
		diamondPickAxe.hasEffect();
		this.func_92051_a(diamondPickAxe, new Object[] {"EE", "SB", Character.valueOf('E'), Item.emerald, Character.valueOf('S'), Item.pickaxeDiamond, Character.valueOf('B'), Item.ghastTear});
		
		//Tools Fortune
		ItemStack goldSpade1 = new ItemStack(Item.shovelGold);
		goldSpade1.addEnchantment(Enchantment.fortune, 3);
		goldSpade1.hasEffect();
		this.func_92051_a(goldSpade1, new Object[] {"GG", "SB", Character.valueOf('G'), Item.goldNugget, Character.valueOf('S'), Item.shovelGold, Character.valueOf('B'), Item.fermentedSpiderEye});
		ItemStack goldAxe1 = new ItemStack(Item.axeGold);
		goldAxe1.addEnchantment(Enchantment.fortune, 3);
		goldAxe1.hasEffect();
		this.func_92051_a(goldAxe1, new Object[] {"GG", "SB", Character.valueOf('G'), Item.goldNugget, Character.valueOf('S'), Item.axeGold, Character.valueOf('B'), Item.fermentedSpiderEye});
		ItemStack goldPickAxe1 = new ItemStack(Item.pickaxeGold);
		goldPickAxe1.addEnchantment(Enchantment.fortune, 3);
		goldPickAxe1.hasEffect();
		this.func_92051_a(goldPickAxe1, new Object[] {"GG", "SB", Character.valueOf('G'), Item.goldNugget, Character.valueOf('S'), Item.pickaxeGold, Character.valueOf('B'), Item.fermentedSpiderEye});
		ItemStack diamondSpade1 = new ItemStack(Item.shovelDiamond);
		diamondSpade1.addEnchantment(Enchantment.fortune, 3);
		diamondSpade1.hasEffect();
		this.func_92051_a(diamondSpade1, new Object[] {"GG", "SB", Character.valueOf('G'), Item.goldNugget, Character.valueOf('S'), Item.shovelDiamond, Character.valueOf('B'), Item.fermentedSpiderEye});
		ItemStack diamondAxe1 = new ItemStack(Item.axeDiamond);
		diamondAxe1.addEnchantment(Enchantment.fortune, 3);
		diamondAxe1.hasEffect();
		this.func_92051_a(diamondAxe1, new Object[] {"GG", "SB", Character.valueOf('G'), Item.goldNugget, Character.valueOf('S'), Item.axeDiamond, Character.valueOf('B'), Item.fermentedSpiderEye});
		ItemStack diamondPickAxe1 = new ItemStack(Item.pickaxeDiamond);
		diamondPickAxe1.addEnchantment(Enchantment.fortune, 3);
		diamondPickAxe1.hasEffect();
		this.func_92051_a(diamondPickAxe1, new Object[] {"GG", "SB", Character.valueOf('G'), Item.goldNugget, Character.valueOf('S'), Item.pickaxeDiamond, Character.valueOf('B'), Item.fermentedSpiderEye});
		
		//Tools Silk Touch
		ItemStack shears1 = new ItemStack(Item.shears);
		shears1.addEnchantment(Enchantment.silkTouch, 3);
		shears1.hasEffect();
		this.func_92051_a(shears1, new Object[] {"CD", "SB", Character.valueOf('C'), Block.cloth, Character.valueOf('S'), Item.shears, Character.valueOf('D'), Item.diamond, Character.valueOf('B'), Item.enderPearl});
		ItemStack goldSpade2 = new ItemStack(Item.shovelGold);
		goldSpade2.addEnchantment(Enchantment.silkTouch, 3);
		goldSpade2.hasEffect();
		this.func_92051_a(goldSpade2, new Object[] {"CD", "SB", Character.valueOf('C'), Block.cloth, Character.valueOf('S'), Item.shovelGold, Character.valueOf('D'), Item.diamond, Character.valueOf('B'), Item.enderPearl});
		ItemStack goldAxe2 = new ItemStack(Item.axeGold);
		goldAxe2.addEnchantment(Enchantment.silkTouch, 3);
		goldAxe2.hasEffect();
		this.func_92051_a(goldAxe2, new Object[] {"CD", "SB", Character.valueOf('C'), Block.cloth, Character.valueOf('S'), Item.axeGold, Character.valueOf('D'), Item.diamond, Character.valueOf('B'), Item.enderPearl});
		ItemStack goldPickAxe2 = new ItemStack(Item.pickaxeGold);
		goldPickAxe2.addEnchantment(Enchantment.silkTouch, 3);
		goldPickAxe2.hasEffect();
		this.func_92051_a(goldPickAxe2, new Object[] {"CD", "SB", Character.valueOf('C'), Block.cloth, Character.valueOf('S'), Item.pickaxeGold, Character.valueOf('D'), Item.diamond, Character.valueOf('B'), Item.enderPearl});
		ItemStack diamondSpade2 = new ItemStack(Item.shovelDiamond);
		diamondSpade2.addEnchantment(Enchantment.silkTouch, 3);
		diamondSpade2.hasEffect();
		this.func_92051_a(diamondSpade2, new Object[] {"CD", "SB", Character.valueOf('C'), Block.cloth, Character.valueOf('S'), Item.shovelDiamond, Character.valueOf('D'), Item.diamond, Character.valueOf('B'), Item.enderPearl});
		ItemStack diamondAxe2 = new ItemStack(Item.axeDiamond);
		diamondAxe2.addEnchantment(Enchantment.silkTouch, 3);
		diamondAxe2.hasEffect();
		this.func_92051_a(diamondAxe2, new Object[] {"CD", "SB", Character.valueOf('C'), Block.cloth, Character.valueOf('S'), Item.axeDiamond, Character.valueOf('D'), Item.diamond, Character.valueOf('B'), Item.enderPearl});
		ItemStack diamondPickAxe2 = new ItemStack(Item.pickaxeDiamond);
		diamondPickAxe2.addEnchantment(Enchantment.silkTouch, 3);
		diamondPickAxe2.hasEffect();
		this.func_92051_a(diamondPickAxe2, new Object[] {"CD", "SB", Character.valueOf('C'), Block.cloth, Character.valueOf('S'), Item.pickaxeDiamond, Character.valueOf('D'), Item.diamond, Character.valueOf('B'), Item.enderPearl});
		
		//Tools Efficiency
		ItemStack shears2 = new ItemStack(Item.shears);
		shears2.addEnchantment(Enchantment.efficiency, 3);
		shears2.hasEffect();
		this.func_92051_a(shears2, new Object[] {"DF", "SB", Character.valueOf('D'), Item.diamond, Character.valueOf('S'), Item.shears, Character.valueOf('F'), Item.feather, Character.valueOf('B'), Item.blazeRod});
		ItemStack goldSpade3 = new ItemStack(Item.shovelGold);
		goldSpade3.addEnchantment(Enchantment.efficiency, 3);
		goldSpade3.hasEffect();
		this.func_92051_a(goldSpade3, new Object[] {"DF", "SB", Character.valueOf('D'), Item.diamond, Character.valueOf('S'), Item.shovelGold, Character.valueOf('F'), Item.feather, Character.valueOf('B'), Item.blazeRod});
		ItemStack goldAxe3 = new ItemStack(Item.axeGold);
		goldAxe3.addEnchantment(Enchantment.efficiency, 3);
		goldAxe3.hasEffect();
		this.func_92051_a(goldAxe3, new Object[] {"DF", "SB", Character.valueOf('D'), Item.diamond, Character.valueOf('S'), Item.axeGold, Character.valueOf('F'), Item.feather, Character.valueOf('B'), Item.blazeRod});
		ItemStack goldPickAxe3 = new ItemStack(Item.pickaxeGold);
		goldPickAxe3.addEnchantment(Enchantment.efficiency, 3);
		goldPickAxe3.hasEffect();
		this.func_92051_a(goldPickAxe3, new Object[] {"DF", "SB", Character.valueOf('D'), Item.diamond, Character.valueOf('S'), Item.pickaxeGold, Character.valueOf('F'), Item.feather, Character.valueOf('B'), Item.blazeRod});
		ItemStack diamondSpade3 = new ItemStack(Item.shovelDiamond);
		diamondSpade3.addEnchantment(Enchantment.efficiency, 3);
		diamondSpade3.hasEffect();
		this.func_92051_a(diamondSpade3, new Object[] {"DF", "SB", Character.valueOf('D'), Item.diamond, Character.valueOf('S'), Item.shovelDiamond, Character.valueOf('F'), Item.feather, Character.valueOf('B'), Item.blazeRod});
		ItemStack diamondAxe3 = new ItemStack(Item.axeDiamond);
		diamondAxe3.addEnchantment(Enchantment.efficiency, 3);
		diamondAxe3.hasEffect();
		this.func_92051_a(diamondAxe3, new Object[] {"DF", "SB", Character.valueOf('D'), Item.diamond, Character.valueOf('S'), Item.axeDiamond, Character.valueOf('F'), Item.feather, Character.valueOf('B'), Item.blazeRod});
		ItemStack diamondPickAxe3 = new ItemStack(Item.pickaxeDiamond);
		diamondPickAxe3.addEnchantment(Enchantment.efficiency, 3);
		diamondPickAxe3.hasEffect();
		this.func_92051_a(diamondPickAxe3, new Object[] {"DF", "SB", Character.valueOf('D'), Item.diamond, Character.valueOf('S'), Item.pickaxeDiamond, Character.valueOf('F'), Item.feather, Character.valueOf('B'), Item.blazeRod});
		
		//Weapons Unbreaking
		ItemStack goldSword = new ItemStack(Item.swordGold);
		goldSword.addEnchantment(Enchantment.unbreaking, 3);
		goldSword.hasEffect();
		this.func_92051_a(goldSword, new Object[] {"DE", "SI", Character.valueOf('D'), Item.diamond, Character.valueOf('E'), Item.emerald, Character.valueOf('S'), Item.swordGold, Character.valueOf('I'), Item.ghastTear});
		ItemStack diamondSword = new ItemStack(Item.swordDiamond);
		diamondSword.addEnchantment(Enchantment.unbreaking, 3);
		diamondSword.hasEffect();
		this.func_92051_a(diamondSword, new Object[] {"EE", "SI", Character.valueOf('E'), Item.emerald, Character.valueOf('S'), Item.swordDiamond, Character.valueOf('I'), Item.ghastTear});
		
		//Weapons Looting
		ItemStack goldSword1 = new ItemStack(Item.swordGold);
		goldSword1.addEnchantment(Enchantment.looting, 3);
		goldSword1.hasEffect();
		this.func_92051_a(goldSword1, new Object[] {"I ", "SB", Character.valueOf('I'), Item.ingotGold, Character.valueOf('S'), Item.swordGold, Character.valueOf('B'), Item.goldenCarrot});
		ItemStack goldAxe4 = new ItemStack(Item.axeGold);
		goldAxe4.addEnchantment(Enchantment.looting, 3);
		goldAxe4.hasEffect();
		this.func_92051_a(goldAxe4, new Object[] {"I ", "SB", Character.valueOf('I'), Item.ingotGold, Character.valueOf('S'), Item.axeGold, Character.valueOf('B'), Item.goldenCarrot});
		ItemStack diamondSword1 = new ItemStack(Item.swordDiamond);
		diamondSword1.addEnchantment(Enchantment.looting, 3);
		diamondSword1.hasEffect();
		this.func_92051_a(diamondSword1, new Object[] {"I ", "SB", Character.valueOf('I'), Item.ingotGold, Character.valueOf('S'), Item.swordDiamond, Character.valueOf('B'), Item.goldenCarrot});
		ItemStack diamondAxe4 = new ItemStack(Item.axeDiamond);
		diamondAxe4.addEnchantment(Enchantment.looting, 3);
		diamondAxe4.hasEffect();
		this.func_92051_a(diamondAxe4, new Object[] {"I ", "SB", Character.valueOf('I'), Item.ingotGold, Character.valueOf('S'), Item.axeDiamond, Character.valueOf('B'), Item.goldenCarrot});
		
		//Weapons FireAspect
		ItemStack goldSword2 = new ItemStack(Item.swordGold);
		goldSword2.addEnchantment(Enchantment.fireAspect, 2);
		goldSword2.hasEffect();
		this.func_92051_a(goldSword2, new Object[] {"I ", "SB", Character.valueOf('I'), Item.flintAndSteel, Character.valueOf('S'), Item.swordGold, Character.valueOf('B'), Item.magmaCream});
		ItemStack diamondSword2 = new ItemStack(Item.swordDiamond);
		diamondSword2.addEnchantment(Enchantment.fireAspect, 2);
		diamondSword2.hasEffect();
		this.func_92051_a(diamondSword2, new Object[] {"I ", "SB", Character.valueOf('I'), Item.flintAndSteel, Character.valueOf('S'), Item.swordDiamond, Character.valueOf('B'), Item.magmaCream});
		
		//Weapons Knockback
		ItemStack goldSword3 = new ItemStack(Item.swordGold);
		goldSword3.addEnchantment(Enchantment.knockback, 2);
		goldSword3.hasEffect();
		this.func_92051_a(goldSword3, new Object[] {"I ", "S ", Character.valueOf('I'), Item.ingotIron, Character.valueOf('S'), Item.swordGold});
		ItemStack diamondSword3 = new ItemStack(Item.swordDiamond);
		diamondSword3.addEnchantment(Enchantment.knockback, 2);
		diamondSword3.hasEffect();
		this.func_92051_a(diamondSword3, new Object[] {"I ", "S ", Character.valueOf('I'), Item.ingotIron, Character.valueOf('S'), Item.swordDiamond});
		
		//Weapons Bane of Arthropods
		ItemStack goldSword4 = new ItemStack(Item.swordGold);
		goldSword4.addEnchantment(Enchantment.baneOfArthropods, 5);
		goldSword4.hasEffect();
		this.func_92051_a(goldSword4, new Object[] {"I ", "SB", Character.valueOf('I'), Item.swordIron, Character.valueOf('S'), Item.swordGold, Character.valueOf('B'), Item.spiderEye});
		ItemStack goldAxe5 = new ItemStack(Item.axeGold);
		goldAxe5.addEnchantment(Enchantment.baneOfArthropods, 5);
		goldAxe5.hasEffect();
		this.func_92051_a(goldAxe5, new Object[] {"I ", "SB", Character.valueOf('I'), Item.swordIron, Character.valueOf('S'), Item.axeGold, Character.valueOf('B'), Item.spiderEye});
		ItemStack diamondSword4 = new ItemStack(Item.swordDiamond);
		diamondSword4.addEnchantment(Enchantment.baneOfArthropods, 5);
		diamondSword4.hasEffect();
		this.func_92051_a(diamondSword4, new Object[] {"I ", "SB", Character.valueOf('I'), Item.swordIron, Character.valueOf('S'), Item.swordDiamond, Character.valueOf('B'), Item.spiderEye});
		ItemStack diamondAxe5 = new ItemStack(Item.axeDiamond);
		diamondAxe5.addEnchantment(Enchantment.baneOfArthropods, 5);
		diamondAxe5.hasEffect();
		this.func_92051_a(diamondAxe5, new Object[] {"I ", "SB", Character.valueOf('I'), Item.swordIron, Character.valueOf('S'), Item.axeDiamond, Character.valueOf('B'), Item.spiderEye});
		
		//Weapons Smite
		ItemStack goldSword5 = new ItemStack(Item.swordGold);
		goldSword5.addEnchantment(Enchantment.smite, 5);
		goldSword5.hasEffect();
		this.func_92051_a(goldSword5, new Object[] {"I ", "S ", Character.valueOf('I'), Item.netherStar, Character.valueOf('S'), Item.swordGold});
		ItemStack goldAxe6 = new ItemStack(Item.axeGold);
		goldAxe6.addEnchantment(Enchantment.smite, 5);
		goldAxe6.hasEffect();
		this.func_92051_a(goldAxe6, new Object[] {"I ", "S ", Character.valueOf('I'), Item.netherStar, Character.valueOf('S'), Item.axeGold});
		ItemStack diamondSword5 = new ItemStack(Item.swordDiamond);
		diamondSword5.addEnchantment(Enchantment.smite, 5);
		diamondSword5.hasEffect();
		this.func_92051_a(diamondSword5, new Object[] {"I ", "S ", Character.valueOf('I'), Item.netherStar, Character.valueOf('S'), Item.swordDiamond});
		ItemStack diamondAxe6 = new ItemStack(Item.axeDiamond);
		diamondAxe6.addEnchantment(Enchantment.smite, 5);
		diamondAxe6.hasEffect();
		this.func_92051_a(diamondAxe6, new Object[] {"I ", "S ", Character.valueOf('I'), Item.netherStar, Character.valueOf('S'), Item.axeDiamond});
		
		//Weapons Sharpness
		ItemStack goldSword6 = new ItemStack(Item.swordGold);
		goldSword6.addEnchantment(Enchantment.sharpness, 5);
		goldSword6.hasEffect();
		this.func_92051_a(goldSword6, new Object[] {"I ", "SB", Character.valueOf('I'), Item.shears, Character.valueOf('S'), Item.swordGold, Character.valueOf('B'), Item.diamond});
		ItemStack goldAxe7 = new ItemStack(Item.axeGold);
		goldAxe7.addEnchantment(Enchantment.sharpness, 5);
		goldAxe7.hasEffect();
		this.func_92051_a(goldAxe7, new Object[] {"I ", "SB", Character.valueOf('I'), Item.shears, Character.valueOf('S'), Item.axeGold, Character.valueOf('B'), Item.diamond});
		ItemStack diamondSword6 = new ItemStack(Item.swordDiamond);
		diamondSword6.addEnchantment(Enchantment.sharpness, 5);
		diamondSword6.hasEffect();
		this.func_92051_a(diamondSword6, new Object[] {"I ", "SB", Character.valueOf('I'), Item.shears, Character.valueOf('S'), Item.swordDiamond, Character.valueOf('B'), Item.diamond});
		ItemStack diamondAxe7 = new ItemStack(Item.axeDiamond);
		diamondAxe7.addEnchantment(Enchantment.sharpness, 5);
		diamondAxe7.hasEffect();
		this.func_92051_a(diamondAxe7, new Object[] {"I ", "SB", Character.valueOf('I'), Item.shears, Character.valueOf('S'), Item.axeDiamond, Character.valueOf('B'), Item.diamond});
		
		//Armor Feather Falling
		ItemStack goldBoots = new ItemStack(Item.bootsGold);
		goldBoots.addEnchantment(Enchantment.featherFalling, 4);
		goldBoots.hasEffect();
		this.func_92051_a(goldBoots, new Object[] {"FB", "SB", Character.valueOf('F'), Item.feather, Character.valueOf('S'), Item.bootsGold, Character.valueOf('B'), Item.slimeBall});
		ItemStack diamondBoots = new ItemStack(Item.bootsDiamond);
		diamondBoots.addEnchantment(Enchantment.featherFalling, 4);
		diamondBoots.hasEffect();
		this.func_92051_a(diamondBoots, new Object[] {"FB", "SB", Character.valueOf('F'), Item.feather, Character.valueOf('S'), Item.bootsDiamond, Character.valueOf('B'), Item.slimeBall});
		
		//Armor Aqua Affinity
		ItemStack goldHelmet = new ItemStack(Item.helmetGold);
		goldHelmet.addEnchantment(Enchantment.aquaAffinity, 1);
		goldHelmet.hasEffect();
		this.func_92051_a(goldHelmet, new Object[] {"P ", "SB", Character.valueOf('P'), Block.pumpkin, Character.valueOf('S'), Item.helmetGold, Character.valueOf('B'), Item.reed});
		ItemStack diamondHelmet = new ItemStack(Item.helmetDiamond);
		diamondHelmet.addEnchantment(Enchantment.aquaAffinity, 1);
		diamondHelmet.hasEffect();
		this.func_92051_a(diamondHelmet, new Object[] {"P ", "SB", Character.valueOf('P'), Block.pumpkin, Character.valueOf('S'), Item.helmetDiamond, Character.valueOf('B'), Item.reed});
		
		//Armor Respiration
		ItemStack goldHelmet1 = new ItemStack(Item.helmetGold);
		goldHelmet1.addEnchantment(Enchantment.respiration, 3);
		goldHelmet1.hasEffect();
		this.func_92051_a(goldHelmet1, new Object[] {"PR", "SR", Character.valueOf('P'), Block.pumpkin, Character.valueOf('R'), Item.reed, Character.valueOf('S'), Item.helmetGold});
		ItemStack diamondHelmet1 = new ItemStack(Item.helmetDiamond);
		diamondHelmet1.addEnchantment(Enchantment.respiration, 3);
		diamondHelmet1.hasEffect();
		this.func_92051_a(diamondHelmet1, new Object[] {"PR", "SR", Character.valueOf('P'), Block.pumpkin, Character.valueOf('R'), Item.reed, Character.valueOf('S'), Item.helmetDiamond});
		
		//Armor Protection
		ItemStack goldBoots1 = new ItemStack(Item.bootsGold);
		goldBoots1.addEnchantment(Enchantment.protection, 4);
		goldBoots1.hasEffect();
		this.func_92051_a(goldBoots1, new Object[] {"A ", "SB", Character.valueOf('A'), Block.cactus, Character.valueOf('S'), Item.bootsGold, Character.valueOf('B'), Item.blazePowder});
		ItemStack goldLegs = new ItemStack(Item.legsGold);
		goldLegs.addEnchantment(Enchantment.protection, 4);
		goldLegs.hasEffect();
		this.func_92051_a(goldLegs, new Object[] {"A ", "SB", Character.valueOf('A'), Block.cactus, Character.valueOf('S'), Item.legsGold, Character.valueOf('B'), Item.blazePowder});
		ItemStack goldPlate = new ItemStack(Item.plateGold);
		goldPlate.addEnchantment(Enchantment.protection, 4);
		goldPlate.hasEffect();
		this.func_92051_a(goldPlate, new Object[] {"A ", "SB", Character.valueOf('A'), Block.cactus, Character.valueOf('S'), Item.plateGold, Character.valueOf('B'), Item.blazePowder});
		ItemStack goldHelmet2 = new ItemStack(Item.helmetGold);
		goldHelmet2.addEnchantment(Enchantment.protection, 4);
		goldHelmet2.hasEffect();
		this.func_92051_a(goldHelmet2, new Object[] {"A ", "SB", Character.valueOf('A'), Block.cactus, Character.valueOf('S'), Item.helmetGold, Character.valueOf('B'), Item.blazePowder});
		ItemStack diamondBoots1 = new ItemStack(Item.bootsDiamond);
		diamondBoots1.addEnchantment(Enchantment.protection, 4);
		diamondBoots1.hasEffect();
		this.func_92051_a(diamondBoots1, new Object[] {"A ", "SB", Character.valueOf('A'), Block.cactus, Character.valueOf('S'), Item.bootsDiamond, Character.valueOf('B'), Item.blazePowder});
		ItemStack diamondLegs = new ItemStack(Item.legsDiamond);
		diamondLegs.addEnchantment(Enchantment.protection, 4);
		diamondLegs.hasEffect();
		this.func_92051_a(diamondLegs, new Object[] {"A ", "SB", Character.valueOf('A'), Block.cactus, Character.valueOf('S'), Item.legsDiamond, Character.valueOf('B'), Item.blazePowder});
		ItemStack diamondPlate = new ItemStack(Item.plateDiamond);
		diamondPlate.addEnchantment(Enchantment.protection, 4);
		diamondPlate.hasEffect();
		this.func_92051_a(diamondPlate, new Object[] {"A ", "SB", Character.valueOf('A'), Block.cactus, Character.valueOf('S'), Item.plateDiamond, Character.valueOf('B'), Item.blazePowder});
		ItemStack diamondHelmet2 = new ItemStack(Item.helmetDiamond);
		diamondHelmet2.addEnchantment(Enchantment.protection, 4);
		diamondHelmet2.hasEffect();
		this.func_92051_a(diamondHelmet2, new Object[] {"A ", "SB", Character.valueOf('A'), Block.cactus, Character.valueOf('S'), Item.helmetDiamond, Character.valueOf('B'), Item.blazePowder});
				
		//Armor Fire Protection
		ItemStack goldBoots2 = new ItemStack(Item.bootsGold);
		goldBoots2.addEnchantment(Enchantment.fireProtection, 4);
		goldBoots2.hasEffect();
		this.func_92051_a(goldBoots2, new Object[] {"P ", "SB", Character.valueOf('P'), new ItemStack(Item.dyePowder, 1, 4), Character.valueOf('S'), Item.bootsGold, Character.valueOf('B'), Item.bucketLava});
		ItemStack goldLegs1 = new ItemStack(Item.legsGold);
		goldLegs1.addEnchantment(Enchantment.fireProtection, 4);
		goldLegs1.hasEffect();
		this.func_92051_a(goldLegs1, new Object[] {"P ", "SB", Character.valueOf('P'), new ItemStack(Item.dyePowder, 1, 4), Character.valueOf('S'), Item.legsGold, Character.valueOf('B'), Item.bucketLava});
		ItemStack goldPlate1 = new ItemStack(Item.plateGold);
		goldPlate1.addEnchantment(Enchantment.fireProtection, 4);
		goldPlate1.hasEffect();
		this.func_92051_a(goldPlate1, new Object[] {"P ", "SB", Character.valueOf('P'), new ItemStack(Item.dyePowder, 1, 4), Character.valueOf('S'), Item.plateGold, Character.valueOf('B'), Item.bucketLava});
		ItemStack goldHelmet3 = new ItemStack(Item.helmetGold);
		goldHelmet3.addEnchantment(Enchantment.fireProtection, 4);
		goldHelmet3.hasEffect();
		this.func_92051_a(goldHelmet3, new Object[] {"P ", "SB", Character.valueOf('P'), new ItemStack(Item.dyePowder, 1, 4), Character.valueOf('S'), Item.helmetGold, Character.valueOf('B'), Item.bucketLava});
		ItemStack diamondBoots2 = new ItemStack(Item.bootsDiamond);
		diamondBoots2.addEnchantment(Enchantment.fireProtection, 4);
		diamondBoots2.hasEffect();
		this.func_92051_a(diamondBoots2, new Object[] {"P ", "SB", Character.valueOf('P'), new ItemStack(Item.dyePowder, 1, 4), Character.valueOf('S'), Item.bootsDiamond, Character.valueOf('B'), Item.bucketLava});
		ItemStack diamondLegs1 = new ItemStack(Item.legsDiamond);
		diamondLegs1.addEnchantment(Enchantment.fireProtection, 4);
		diamondLegs1.hasEffect();
		this.func_92051_a(diamondLegs1, new Object[] {"P ", "SB", Character.valueOf('P'), new ItemStack(Item.dyePowder, 1, 4), Character.valueOf('S'), Item.legsDiamond, Character.valueOf('B'), Item.bucketLava});
		ItemStack diamondPlate1 = new ItemStack(Item.plateDiamond);
		diamondPlate1.addEnchantment(Enchantment.fireProtection, 4);
		diamondPlate1.hasEffect();
		this.func_92051_a(diamondPlate1, new Object[] {"P ", "SB", Character.valueOf('P'), new ItemStack(Item.dyePowder, 1, 4), Character.valueOf('S'), Item.plateDiamond, Character.valueOf('B'), Item.bucketLava});
		ItemStack diamondHelmet3 = new ItemStack(Item.helmetDiamond);
		diamondHelmet3.addEnchantment(Enchantment.fireProtection, 4);
		diamondHelmet3.hasEffect();
		this.func_92051_a(diamondHelmet3, new Object[] {"P ", "SB", Character.valueOf('P'), new ItemStack(Item.dyePowder, 1, 4), Character.valueOf('S'), Item.helmetDiamond, Character.valueOf('B'), Item.bucketLava});
				
		//Armor Blast Protection
		ItemStack goldBoots4 = new ItemStack(Item.bootsGold);
		goldBoots4.addEnchantment(Enchantment.blastProtection, 4);
		goldBoots4.hasEffect();
		this.func_92051_a(goldBoots4, new Object[] {"OO", "SB", Character.valueOf('O'), Block.obsidian, Character.valueOf('S'), Item.bootsGold, Character.valueOf('B'), Item.bucketLava});
		ItemStack goldLegs4 = new ItemStack(Item.legsGold);
		goldLegs4.addEnchantment(Enchantment.blastProtection, 4);
		goldLegs4.hasEffect();
		this.func_92051_a(goldLegs4, new Object[] {"OO", "SB", Character.valueOf('O'), Block.obsidian, Character.valueOf('S'), Item.legsGold, Character.valueOf('B'), Item.bucketLava});
		ItemStack goldPlate4 = new ItemStack(Item.plateGold);
		goldPlate4.addEnchantment(Enchantment.blastProtection, 4);
		goldPlate4.hasEffect();
		this.func_92051_a(goldPlate4, new Object[] {"OO", "SB", Character.valueOf('O'), Block.obsidian, Character.valueOf('S'), Item.plateGold, Character.valueOf('B'), Item.bucketLava});
		ItemStack goldHelmet4 = new ItemStack(Item.helmetGold);
				goldHelmet4.addEnchantment(Enchantment.blastProtection, 4);
		goldHelmet4.hasEffect();
		this.func_92051_a(goldHelmet4, new Object[] {"OO", "SB", Character.valueOf('O'), Block.obsidian, Character.valueOf('S'), Item.helmetGold, Character.valueOf('B'), Item.bucketLava});
		ItemStack diamondBoots4 = new ItemStack(Item.bootsDiamond);
		diamondBoots4.addEnchantment(Enchantment.blastProtection, 4);
		diamondBoots4.hasEffect();
		this.func_92051_a(diamondBoots4, new Object[] {"OO", "SB", Character.valueOf('O'), Block.obsidian, Character.valueOf('S'), Item.bootsDiamond, Character.valueOf('B'), Item.bucketLava});
		ItemStack diamondLegs4 = new ItemStack(Item.legsDiamond);
		diamondLegs4.addEnchantment(Enchantment.blastProtection, 4);
		diamondLegs4.hasEffect();
		this.func_92051_a(diamondLegs4, new Object[] {"OO", "SB", Character.valueOf('O'), Block.obsidian, Character.valueOf('S'), Item.legsDiamond, Character.valueOf('B'), Item.bucketLava});
		ItemStack diamondPlate4 = new ItemStack(Item.plateDiamond);
		diamondPlate4.addEnchantment(Enchantment.blastProtection, 4);
		diamondPlate4.hasEffect();
		this.func_92051_a(diamondPlate4, new Object[] {"OO", "SB", Character.valueOf('O'), Block.obsidian, Character.valueOf('S'), Item.plateDiamond, Character.valueOf('B'), Item.bucketLava});
		ItemStack diamondHelmet4 = new ItemStack(Item.helmetDiamond);
		diamondHelmet4.addEnchantment(Enchantment.blastProtection, 4);
		diamondHelmet4.hasEffect();
		this.func_92051_a(diamondHelmet4, new Object[] {"OO", "SB", Character.valueOf('O'), Block.obsidian, Character.valueOf('S'), Item.helmetDiamond, Character.valueOf('B'), Item.bucketLava});
				
		//Armor Projectile Protection
		ItemStack goldBoots5 = new ItemStack(Item.bootsGold);
		goldBoots5.addEnchantment(Enchantment.projectileProtection, 4);
		goldBoots5.hasEffect();
		this.func_92051_a(goldBoots5, new Object[] {"RR", "SB", Character.valueOf('R'), new ItemStack(Item.bone, 2, 0), Character.valueOf('S'), Item.bootsGold, Character.valueOf('B'), Item.bucketLava});
		ItemStack goldLegs5 = new ItemStack(Item.legsGold);
		goldLegs5.addEnchantment(Enchantment.projectileProtection, 4);
		goldLegs5.hasEffect();
		this.func_92051_a(goldLegs5, new Object[] {"RR", "SB", Character.valueOf('R'), new ItemStack(Item.bone, 2, 0), Character.valueOf('S'), Item.legsGold, Character.valueOf('B'), Item.bucketLava});
		ItemStack goldPlate5 = new ItemStack(Item.plateGold);
		goldPlate5.addEnchantment(Enchantment.projectileProtection, 4);
		goldPlate5.hasEffect();
		this.func_92051_a(goldPlate5, new Object[] {"RR", "SB", Character.valueOf('R'), new ItemStack(Item.bone, 2, 0), Character.valueOf('S'), Item.plateGold, Character.valueOf('B'), Item.bucketLava});
		ItemStack goldHelmet5 = new ItemStack(Item.helmetGold);
		goldHelmet5.addEnchantment(Enchantment.projectileProtection, 4);
		goldHelmet5.hasEffect();
		this.func_92051_a(goldHelmet5, new Object[] {"RR", "SB", Character.valueOf('R'), new ItemStack(Item.bone, 2, 0), Character.valueOf('S'), Item.helmetGold, Character.valueOf('B'), Item.bucketLava});
		ItemStack diamondBoots5 = new ItemStack(Item.bootsDiamond);
		diamondBoots5.addEnchantment(Enchantment.projectileProtection, 4);
		diamondBoots5.hasEffect();
		this.func_92051_a(diamondBoots5, new Object[] {"RR", "SB", Character.valueOf('R'), new ItemStack(Item.bone, 2, 0), Character.valueOf('S'), Item.bootsDiamond, Character.valueOf('B'), Item.bucketLava});
		ItemStack diamondLegs5 = new ItemStack(Item.legsDiamond);
		diamondLegs5.addEnchantment(Enchantment.projectileProtection, 4);
		diamondLegs5.hasEffect();
		this.func_92051_a(diamondLegs5, new Object[] {"RR", "SB", Character.valueOf('R'), new ItemStack(Item.bone, 2, 0), Character.valueOf('S'), Item.legsDiamond, Character.valueOf('B'), Item.bucketLava});
		ItemStack diamondPlate5 = new ItemStack(Item.plateDiamond);
		diamondPlate5.addEnchantment(Enchantment.projectileProtection, 4);
		diamondPlate5.hasEffect();
		this.func_92051_a(diamondPlate5, new Object[] {"RR", "SB", Character.valueOf('R'), new ItemStack(Item.bone, 2, 0), Character.valueOf('S'), Item.plateDiamond, Character.valueOf('B'), Item.bucketLava});
		ItemStack diamondHelmet5 = new ItemStack(Item.helmetDiamond);
		diamondHelmet5.addEnchantment(Enchantment.projectileProtection, 4);
		diamondHelmet5.hasEffect();
		this.func_92051_a(diamondHelmet5, new Object[] {"RR", "SB", Character.valueOf('R'), new ItemStack(Item.bone, 2, 0), Character.valueOf('S'), Item.helmetDiamond, Character.valueOf('B'), Item.bucketLava});
				
		//Armor Thorns
		ItemStack goldBoots6 = new ItemStack(Item.bootsGold);
		goldBoots6.addEnchantment(Enchantment.thorns, 3);
		goldBoots6.hasEffect();
		this.func_92051_a(goldBoots6, new Object[] {"TT", "SB", Character.valueOf('T'), new ItemStack(Item.arrow, 2, 0), Character.valueOf('S'), Item.bootsGold, Character.valueOf('B'), Item.bucketLava});
		ItemStack goldLegs6 = new ItemStack(Item.legsGold);
		goldLegs6.addEnchantment(Enchantment.thorns, 3);
		goldLegs6.hasEffect();
		this.func_92051_a(goldLegs6, new Object[] {"TT", "SB", Character.valueOf('T'), Item.arrow, Character.valueOf('S'), Item.legsGold, Character.valueOf('B'), Item.bucketLava});
		ItemStack goldPlate6 = new ItemStack(Item.plateGold);
		goldPlate6.addEnchantment(Enchantment.thorns, 3);
		goldPlate6.hasEffect();
		this.func_92051_a(goldPlate6, new Object[] {"TT", "SB", Character.valueOf('T'), Item.arrow, Character.valueOf('S'), Item.plateGold, Character.valueOf('B'), Item.bucketLava});
		ItemStack goldHelmet6 = new ItemStack(Item.helmetGold);
		goldHelmet6.addEnchantment(Enchantment.thorns, 3);
		goldHelmet6.hasEffect();
		this.func_92051_a(goldHelmet6, new Object[] {"TT", "SB", Character.valueOf('T'), Item.arrow, Character.valueOf('S'), Item.helmetGold, Character.valueOf('B'), Item.bucketLava});
		ItemStack diamondBoots6 = new ItemStack(Item.bootsDiamond);
		diamondBoots6.addEnchantment(Enchantment.thorns, 3);
		diamondBoots6.hasEffect();
		this.func_92051_a(diamondBoots6, new Object[] {"TT", "SB", Character.valueOf('T'), Item.arrow, Character.valueOf('S'), Item.bootsDiamond, Character.valueOf('B'), Item.bucketLava});
		ItemStack diamondLegs6 = new ItemStack(Item.legsDiamond);
		diamondLegs6.addEnchantment(Enchantment.thorns, 3);
		diamondLegs6.hasEffect();
		this.func_92051_a(diamondLegs6, new Object[] {"TT", "SB", Character.valueOf('T'), Item.arrow, Character.valueOf('S'), Item.legsDiamond, Character.valueOf('B'), Item.bucketLava});
		ItemStack diamondPlate6 = new ItemStack(Item.plateDiamond);
		diamondPlate6.addEnchantment(Enchantment.thorns, 3);
		diamondPlate6.hasEffect();
		this.func_92051_a(diamondPlate6, new Object[] {"TT", "SB", Character.valueOf('T'), Item.arrow, Character.valueOf('S'), Item.plateDiamond, Character.valueOf('B'), Item.bucketLava});
		ItemStack diamondHelmet6 = new ItemStack(Item.helmetDiamond);
		diamondHelmet6.addEnchantment(Enchantment.thorns, 3);
		diamondHelmet6.hasEffect();
		this.func_92051_a(diamondHelmet6, new Object[] {"TT", "SB", Character.valueOf('T'), Item.arrow, Character.valueOf('S'), Item.helmetDiamond, Character.valueOf('B'), Item.bucketLava});
				
		//Armor Unbreaking
		ItemStack goldBoots7 = new ItemStack(Item.bootsGold);
		goldBoots7.addEnchantment(Enchantment.unbreaking, 3);
		goldBoots7.hasEffect();
		this.func_92051_a(goldBoots7, new Object[] {"OO", "SB", Character.valueOf('O'), Block.obsidian, Character.valueOf('S'), Item.bootsGold, Character.valueOf('B'), Item.blazeRod});
		ItemStack goldLegs7 = new ItemStack(Item.legsGold);
		goldLegs7.addEnchantment(Enchantment.unbreaking, 3);
		goldLegs7.hasEffect();
		this.func_92051_a(goldLegs7, new Object[] {"OO", "SB", Character.valueOf('O'), Block.obsidian, Character.valueOf('S'), Item.legsGold, Character.valueOf('B'), Item.blazeRod});
		ItemStack goldPlate7 = new ItemStack(Item.plateGold);
		goldPlate7.addEnchantment(Enchantment.unbreaking, 3);
		goldPlate7.hasEffect();
		this.func_92051_a(goldPlate7, new Object[] {"OO", "SB", Character.valueOf('O'), Block.obsidian, Character.valueOf('S'), Item.plateGold, Character.valueOf('B'), Item.blazeRod});
		ItemStack goldHelmet7 = new ItemStack(Item.helmetGold);
		goldHelmet7.addEnchantment(Enchantment.unbreaking, 3);
		goldHelmet7.hasEffect();
		this.func_92051_a(goldHelmet7, new Object[] {"OO", "SB", Character.valueOf('O'), Block.obsidian, Character.valueOf('S'), Item.helmetGold, Character.valueOf('B'), Item.blazeRod});
		ItemStack diamondBoots7 = new ItemStack(Item.bootsDiamond);
		diamondBoots7.addEnchantment(Enchantment.unbreaking, 3);
		diamondBoots7.hasEffect();
		this.func_92051_a(diamondBoots7, new Object[] {"OO", "SB", Character.valueOf('O'), Block.obsidian, Character.valueOf('S'), Item.bootsDiamond, Character.valueOf('B'), Item.blazeRod});
		ItemStack diamondLegs7 = new ItemStack(Item.legsDiamond);
		diamondLegs7.addEnchantment(Enchantment.unbreaking, 3);
		diamondLegs7.hasEffect();
		this.func_92051_a(diamondLegs7, new Object[] {"OO", "SB", Character.valueOf('O'), Block.obsidian, Character.valueOf('S'), Item.legsDiamond, Character.valueOf('B'), Item.blazeRod});
		ItemStack diamondPlate7 = new ItemStack(Item.plateDiamond);
		diamondPlate7.addEnchantment(Enchantment.unbreaking, 3);
		diamondPlate7.hasEffect();
		this.func_92051_a(diamondPlate7, new Object[] {"OO", "SB", Character.valueOf('O'), Block.obsidian, Character.valueOf('S'), Item.plateDiamond, Character.valueOf('B'), Item.blazeRod});
		ItemStack diamondHelmet7 = new ItemStack(Item.helmetDiamond);
		diamondHelmet7.addEnchantment(Enchantment.unbreaking, 3);
		diamondHelmet7.hasEffect();
		this.func_92051_a(diamondHelmet7, new Object[] {"OO", "SB", Character.valueOf('O'), Block.obsidian, Character.valueOf('S'), Item.helmetDiamond, Character.valueOf('B'), Item.blazeRod});
		
		//Bows
		ItemStack bow = new ItemStack(Item.bow);
		bow.addEnchantment(Enchantment.infinity, 1);
		bow.hasEffect();
		this.func_92051_a(bow, new Object[] {"AA", "SB", Character.valueOf('A'), Block.cactus, Character.valueOf('S'), Item.bow, Character.valueOf('B'), Item.ghastTear});
		ItemStack bow1 = new ItemStack(Item.bow);
		bow1.addEnchantment(Enchantment.flame, 1);
		bow1.hasEffect();
		this.func_92051_a(bow1, new Object[] {"F ", "SA", Character.valueOf('F'), Item.flintAndSteel, Character.valueOf('S'), Item.bow, Character.valueOf('A'), Item.arrow});
		ItemStack bow2 = new ItemStack(Item.bow);
		bow2.addEnchantment(Enchantment.punch, 2);
		bow2.hasEffect();
		this.func_92051_a(bow2, new Object[] {"II", "S ", Character.valueOf('I'), Item.ingotIron, Character.valueOf('S'), Item.bow});
		ItemStack bow3 = new ItemStack(Item.bow);
		bow3.addEnchantment(Enchantment.power, 5);
		bow3.hasEffect();
		this.func_92051_a(bow3, new Object[] {"D ", "SB", Character.valueOf('D'), Item.netherStar, Character.valueOf('S'), Item.bow, Character.valueOf('B'), new ItemStack(Item.skull, 1, 1)});//Item.goldenCarrot});
		ItemStack bow4 = new ItemStack(Item.bow);
		bow4.addEnchantment(Enchantment.unbreaking, 3);
		bow4.hasEffect();
		this.func_92051_a(bow4, new Object[] {"OO", "SB", Character.valueOf('O'), Block.obsidian, Character.valueOf('S'), Item.bow, Character.valueOf('B'), Item.blazePowder});
		
		//Potions
		//this.func_92051_a(new ItemStack(Item.potion, 1, 8206), new Object[] {"NG", "FE", Character.valueOf('N'), Item.netherStalkSeeds, Character.valueOf('F'), Item.fermentedSpiderEye, Character.valueOf('G'), Item.goldenCarrot, Character.valueOf('E'), Item.glassBottle});
		Collections.sort(this.recipes, new SpiritRecipeSorter(this));
        System.out.println(this.recipes.size() + " recipes");
    }

    public SpiritShapedRecipes func_92051_a(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
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

        SpiritShapedRecipes var17 = new SpiritShapedRecipes(var5, var6, var15, par1ItemStack);
        this.recipes.add(var17);
        return var17;
    }

    public void addSpiritShapelessRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
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

        this.recipes.add(new SpiritShapelessRecipes(par1ItemStack, var3));
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