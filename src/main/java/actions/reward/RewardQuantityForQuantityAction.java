package actions.reward;

import actions.Action;
import domain.Order;
/**
 * Reward a quantity for specific quantity. Ex. TotalQuantity=3 : reward 1 for 2 => TotalQuantity=4
 * */
public class RewardQuantityForQuantityAction implements Action<Order> {
    private final int rewardingQuantity;
    private final int magicQuantity;

    public RewardQuantityForQuantityAction(int rewardingQuantity, int magicQuantity) {
        this.rewardingQuantity = rewardingQuantity;
        this.magicQuantity = magicQuantity;
    }

    @Override
    public void execute(Order candidte) {
        int totalRewardingQuantity=(candidte.getTotalQuantity()/magicQuantity)*rewardingQuantity;
        candidte.setRewardingQuantity(candidte.getRewardingQuantity()+totalRewardingQuantity);
    }
}
