/**
 * @author delini
 */
package repairerRequestedOrder;

public interface TableActionEvent {
    public void onAccept(int row);
    public void onRefuse(int row);
}
