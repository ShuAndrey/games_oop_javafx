package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void whenBishopPosition() {
        Figure bishop = new BishopBlack(Cell.A1);
        Cell expect = Cell.A1;
        assertThat(bishop.position(), is(expect));
    }

    @Test
    public void whenBishopWay() {
        Figure bishop = new BishopBlack(Cell.C1);
        Cell[] result = bishop.way(Cell.G5);
        Cell[] expect = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result[0], is(expect[0]));
        assertThat(result[1], is(expect[1]));
        assertThat(result[2], is(expect[2]));
        assertThat(result[3], is(expect[3]));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenBishopWayIsNotDiagonal() {
        Figure bishop = new BishopBlack(Cell.C1);
        bishop.way(Cell.G6);
    }

    @Test
    public void whenBishopCopy() {
        Figure bishop = new BishopBlack(Cell.A1);
        bishop = bishop.copy(Cell.B2);
        Cell expect = Cell.B2;
        assertThat(bishop.position(), is(expect));
    }

    @Test
    public void whenBishopMoveIsDiagonal() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        boolean result = bishop.isDiagonal(bishop.position(), Cell.G5);
        assertThat(result, is(true));
    }

    @Test
    public void whenBishopMoveIsNotDiagonal() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        boolean result = bishop.isDiagonal(bishop.position(), Cell.G6);
        assertThat(result, is(false));
    }
}