/**
 * @author delini
 */
package customerCurrentOrder;

public interface TableActionEvent {
    public void onUpdate(int row);
    public void onDelete(int row);
    public void onPay(int row);
}
