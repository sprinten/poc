package org.avm.board.ui;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.log4j.Logger;
import org.avm.board.ui.view.AbstractItemView;
import org.avm.framework.ui.dnd.wrapper.CellWrapper;
import org.avm.framework.ui.dnd.wrapper.ColFooterWrapper;
import org.avm.framework.ui.dnd.wrapper.ColHeaderWrapper;
import org.avm.framework.ui.dnd.wrapper.DragableWrapper;
import org.avm.framework.ui.dnd.wrapper.RowHeaderWrapper;
import org.avm.vaadin.aspect.theme.Aspect;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.VerticalLayout;

/**
 * A GridLayout with fixed header/footer/right column/left column The minimal
 * dimension will always be (3,3) with a cell in the middle
 */
public class Whiteboard extends GridLayout {

	private static final long serialVersionUID = 6758753732655427446L;

	private static final Logger LOGGER = Logger.getLogger(Whiteboard.class);

	private int realColCount;
	private int realRowCount;

	private int firstRealCol = 1;
	private int firstRealRow = 1;

	private int topRow = 0;
	private int leftCol = 0;

	private int bottomRow;
	private int rightCol;

	private int lastRealCol;

	private int lastRealRow;

	public Whiteboard(int cols, int rows) {
		super(cols + 2, rows + 2);

		LOGGER.debug("new");
		if (cols == 0 || rows == 0) {
			throw new IllegalArgumentException("Rows and/or columns cannot be 0");
		}

		realColCount = cols;
		realRowCount = rows;

		lastRealCol = getColumns() - 2;
		lastRealRow = getRows() - 2;

		rightCol = getColumns() - 1;
		bottomRow = getRows() - 1;

		//TODO: Check width
		setWidth("1100px");
		addStyleName(Aspect.LAYOUT_BORDERS);
		setSpacing(true);
		fillColHeaders();
		fillCells();

		setRowExpandRatio(topRow, 97.f / (realRowCount - 1));
		setRowExpandRatio(bottomRow, 3.f);

		// setDropHandler(new GridDropHandler(this));
	}

	private void fillColHeaders() {
		setColumnExpandRatio(0, 3.f);
		setColumnExpandRatio(getColumns() - 1, 3.f);

		// fill corners
		fillCorner(leftCol, topRow);
		fillCorner(rightCol, topRow);
		fillCorner(leftCol, bottomRow);
		fillCorner(rightCol, bottomRow);

		// Do not fill with headers first and last column
		for (int col = firstRealCol; col <= lastRealCol; col++) {
			setColumnExpandRatio(col, 96.f / realColCount);
			fillColHeader(col);
			fillColFooter(col);
		}
	}

	private void fillColHeader(int col) {
		ColHeaderWrapper colHeaderWrapper = new ColHeaderWrapper();
		addComponent(colHeaderWrapper, col, topRow);
		setComponentAlignment(colHeaderWrapper, Alignment.MIDDLE_CENTER);
	}

	private void fillColFooter(int col) {
		ColFooterWrapper colFooterWrapper = new ColFooterWrapper(col);
		addComponent(colFooterWrapper, col, bottomRow);
		setComponentAlignment(colFooterWrapper, Alignment.TOP_CENTER);
	}

	private void fillCells() {
		// Do not fill with defaults first and last row
		for (int row = firstRealRow; row <= lastRealRow; row++) {
			fillRow(row);
		}
	}

	private void fillRowHeader(int row) {

		RowHeaderWrapper headerWrapper = new RowHeaderWrapper(row, true);
		removeComponent(leftCol, row);
		addComponent(headerWrapper, leftCol, row);
		setComponentAlignment(headerWrapper, Alignment.MIDDLE_CENTER);

		headerWrapper = new RowHeaderWrapper(row, false);
		removeComponent(rightCol, row);
		addComponent(headerWrapper, rightCol, row);
		setComponentAlignment(headerWrapper, Alignment.MIDDLE_CENTER);
	}

	private void fillRow(int row) {

		setRowExpandRatio(row, 97.f / (realRowCount - 1));

		fillRowHeader(row);
		for (int col = firstRealCol; col <= lastRealCol; col++) {
			fillCell(col, row);
		}
	}

	private void fillCell(int col, int row) {
		addCell(new CellWrapper(), col, row);

	}

	private void fillCorner(int col, int row) {
		super.addComponent(new VerticalLayout(), col, row);
	}

	public void setHeaderTitle(String title, int col) {
		getHeader(col).setTitle(title);
	}

	private ColHeaderWrapper getHeader(int col) {
		return (ColHeaderWrapper) getComponent(col, topRow);
	}

	public void addItemView(AbstractItemView<?> itemView, int col, int row) {
		DragableWrapper wrapper = new DragableWrapper(itemView);

		CellWrapper cellWrapper = getCell(col, row);
		cellWrapper.add(wrapper);
	}

	public CellWrapper getCell(int col, int row) {

		if (col == rightCol || col == leftCol || row == topRow || row == bottomRow) {
			throw new IllegalArgumentException("Rows and/or columns cannot be on the margin");
		}

		return (CellWrapper) getComponent(col, row);
	}

	@Override
	public void insertRow(int row) {
		//TODO: Recheck
//		if (row == topRow || row == bottomRow) {
//			throw new IllegalArgumentException("Rows cannot be on the margin");
//		}

		int nextRow = row + 1;
		super.insertRow(nextRow);

		realRowCount++;
		bottomRow++;
		lastRealRow++;

		fillRow(nextRow);
		updateRowHeaders();
	}

	private void updateRowHeaders() {
		for (int row = firstRealRow; row <= lastRealRow; row++) {
			fillRowHeader(row);
		}
	}

	@Override
	public void removeRow(int row) {
		if (row == topRow || row == bottomRow) {
			throw new IllegalArgumentException("Rows cannot be on the margin");
		}

		super.removeRow(row);

		realRowCount--;
		bottomRow--;
		lastRealRow--;

		updateRowHeaders();
	}

	public void cleanRow(int row) {
		if (row == topRow || row == bottomRow) {
			throw new IllegalArgumentException("Rows cannot be on the margin");
		}

		for (int col = firstRealCol; col <= lastRealCol; col++) {
			getCell(col, row).removeAll();
		}
	}

	public void cleanColumn(int column) {
		if (column == rightCol || column == leftCol) {
			throw new IllegalArgumentException("Rows and/or columns cannot be on the margin");
		}

		for (int row = firstRealRow; row <= lastRealRow; row++) {
			getCell(column, row).removeAll();
		}
	}

	public void moveUpRow(int row) {
		if (row == firstRealRow) {
			return;
		}
		switchRows(row, row - 1);

	}

	public void moveCellsLeft(int col) {
		if (col == firstRealCol) {
			return;
		}
		moveCols(col, col - 1);
	}

	public void moveCellsRight(int col) {
		if (col == lastRealCol) {
			return;
		}
		moveCols(col, col + 1);
	}

	public void moveCols(int col1, int col2) {
		for (int row = firstRealRow; row <= lastRealRow; row++) {
			moveCells(col1, col2, row);
		}
	}

	private void moveCells(int col1, int col2, int row) {
		CellWrapper cellWrapper1 = getCell(col1, row);
		CellWrapper cellWrapper2 = getCell(col2, row);

		Collection<DragableWrapper> components1 = new LinkedList<DragableWrapper>();

		for (Iterator<Component> compIterator1 = cellWrapper1.getIterator(); compIterator1.hasNext();) {
			DragableWrapper component = (DragableWrapper) compIterator1.next();
			components1.add(component);
		}

		cellWrapper1.removeAll();
		cellWrapper2.addAll(components1);
	}

	public void moveDownRow(int row) {
		if (row == lastRealRow) {
			return;
		}
		switchRows(row, row + 1);
	}

	public void switchRows(int row1, int row2) {

		for (int col = firstRealCol; col <= lastRealCol; col++) {
			switchCells(row1, row2, col);

		}
	}

	private void switchCells(int row1, int row2, int col) {
		CellWrapper cellWrapper1 = getCell(col, row1);
		CellWrapper cellWrapper2 = getCell(col, row2);

		removeCell(row1, col);
		removeCell(row2, col);

		addCell(cellWrapper1, col, row2);
		addCell(cellWrapper2, col, row1);
	}

	public void removeCell(int row, int col) {
		removeComponent(col, row);
	}

	public void addCell(CellWrapper cellWrapper, int col, int row) {
		addComponent(cellWrapper, col, row);
		setComponentAlignment(cellWrapper, Alignment.TOP_CENTER);
	}


	public int getFirstRealCol() {
		return firstRealCol;
	}

	public void setFirstRealCol(int firstRealCol) {
		this.firstRealCol = firstRealCol;
	}

	public int getFirstRealRow() {
		return firstRealRow;
	}

	public void setFirstRealRow(int firstRealRow) {
		this.firstRealRow = firstRealRow;
	}

	public int getLastRealCol() {
		return lastRealCol;
	}

	public void setLastRealCol(int lastRealCol) {
		this.lastRealCol = lastRealCol;
	}

	public int getLastRealRow() {
		return lastRealRow;
	}

	public void setLastRealRow(int lastRealRow) {
		this.lastRealRow = lastRealRow;
	}

}
