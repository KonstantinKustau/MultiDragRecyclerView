package com.konstantin.kustov.multidrag;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvBoard;

    ArrayList<Cell> cells;
    BoardAdapter boardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvBoard = findViewById(R.id.mainRecyclerView);

        // Init cells.
        cells = new ArrayList<>();
        cells.add(new Cell("A"));
        cells.add(new Cell("B"));
        cells.add(new Cell("C"));
        cells.add(new Cell("D"));
        cells.add(new Cell("E"));
        cells.add(new Cell("F"));
        cells.add(new Cell("G"));
        cells.add(new Cell("H"));
        cells.add(new Cell("I"));
        cells.add(new Cell("J"));
        cells.add(new Cell("K"));
        cells.add(new Cell("L"));
        cells.add(new Cell("M"));
        cells.add(new Cell("N"));
        cells.add(new Cell("O"));

        boardAdapter = new BoardAdapter(this, R.layout.item, this.cells,
                (int) (ViewUtils.getScreenWidth(this) * 0.24074074074f));
        rvBoard.setAdapter(boardAdapter);

        rvBoard.addOnItemTouchListener(onItemTouchMultiDragListener);
    }

    private final OnItemTouchMultiDragListener onItemTouchMultiDragListener = new OnItemTouchMultiDragListener("touchable") {

        @Override
        public void onDownTouchableView(int pos) {
            boardAdapter.performClickHolder(pos);
        }

        @Override
        public void onMoveTouchableView(int pos) {
            if (!cells.get(pos).isChosen()) {
                onChooseACharFromBoard(pos, cells.get(pos).getCharacter());
            } else {
                sendBackChosenCharToBoard(pos);
            }
        }
    };

    public void onChooseACharFromBoard(int chosenPos, String character) {
        boardAdapter.addLastChosenItem(chosenPos);
        cells.get(chosenPos).setChosen(true);
        boardAdapter.notifyDataSetChanged();
    }

    public void sendBackChosenCharToBoard(int chosenPos) {
        boardAdapter.removeChosenItemByPosition(chosenPos);
        cells.get(chosenPos).setChosen(false);
        boardAdapter.notifyDataSetChanged();
    }

}
