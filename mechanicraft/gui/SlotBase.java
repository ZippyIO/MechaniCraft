package mechanicraft.gui;


import buildcraft.core.gui.tooltips.ToolTip;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

/**
 *
 * @author CovertJaguar <http://www.railcraft.info>
 */
public class SlotBase extends Slot {

        private ToolTip toolTips;

        public SlotBase(IInventory iinventory, int slotIndex, int posX, int posY) {
                super(iinventory, slotIndex, posX, posY);
        }

        public boolean canShift() {
                return true;
        }

        /**
         * @return the toolTips
         */
        public ToolTip getToolTip() {
                return toolTips;
        }

        /**
         * @param toolTips the tooltips to set
         */
        public void setToolTips(ToolTip toolTips) {
                this.toolTips = toolTips;
        }
}
