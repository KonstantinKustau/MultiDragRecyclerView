package com.konstantin.kustov.multidrag;

import android.content.Context;
import android.view.View;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class BoardAdapter extends RecyclerAdapter<Cell> {

    private final int itemSize;

    private final LinkedList<Integer> chosenPositions; // List of character position in board we chose.

    public BoardAdapter(Context context, int resource, List<Cell> listItem, int itemSize) {
        super(context, resource, listItem);
        this.itemSize = itemSize;

        chosenPositions = new LinkedList<>();
    }

    @Override
    public RecyclerViewHolder createHolder(View v) {
        return new BoardHolder(context, v, itemSize);
    }

    public void performClickHolder(int pos) {
        ((BoardHolder) Objects.requireNonNull(recyclerView.findViewHolderForAdapterPosition(pos))).onClick();
    }

    public LinkedList<Integer> getChosenPositions() {
        return chosenPositions;
    }

    public void addLastChosenItem(int position) {
        chosenPositions.addLast(position);
    }

    public void removeChosenItemByPosition(Integer position) {
        chosenPositions.remove(position);
    }
}
