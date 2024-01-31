/**
 * @author delini
 */
package repairerCurrentOrder;

public interface TableActionEvent {
    public void onAccept(int row);
    public void onRefuse(int row);
}
