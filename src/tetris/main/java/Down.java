package tetris.main.java;

public final class Down {
    private final ClearRow clearRow;
    private final ViewTetorimino viewData;

    public Down(ClearRow clearRow, ViewTetorimino viewData) {
        this.clearRow = clearRow;
        this.viewData = viewData;
    }

    public ClearRow getClearRow() {
        return clearRow;
    }

    public ViewTetorimino getViewData() {
        return viewData;
    }
}
