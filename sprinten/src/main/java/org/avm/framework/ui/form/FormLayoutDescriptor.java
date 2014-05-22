package org.avm.framework.ui.form;

import java.util.HashMap;
import java.util.Map;

public class FormLayoutDescriptor {

	private Map<Object, PropertyDescriptor> positions = new HashMap<Object, PropertyDescriptor>();

	private String formName;

	private int cols;

	private int rows;

	public FormLayoutDescriptor(String formName) {
		super();
		this.formName = formName;
	}

	public FormLayoutDescriptor(Map<Object, PropertyDescriptor> positions, String formName) {
		super();
		this.positions = positions;
		this.formName = formName;
	}

	public void addPosition(PropertyDescriptor position) {
		positions.put(position.getPropertyId(),position);
	}

	public Map<Object, PropertyDescriptor> getPositions() {
		return positions;
	}

	public void setPositions(Map<Object, PropertyDescriptor> positions) {
		if (positions == null) {
			throw new IllegalArgumentException("NULL");
		}
		this.positions = positions;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int size) {
		this.cols = size;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public static class PropertyDescriptor {

		private Object propertyId;

		private Integer upLeftCol;

		private Integer upLeftRow;

		private Integer lowRightCol;

		private Integer lowRightRow;

		private Integer width;

		private Integer height;

		PropertyDescriptor(Object propertyId) {
			super();
			this.propertyId = propertyId;
		}

		public Object getPropertyId() {
			return propertyId;
		}

		public void setPropertyId(Object propertyId) {
			this.propertyId = propertyId;
		}

		public Integer getUpLeftCol() {
			return upLeftCol;
		}

		public void setUpLeftCol(Integer col) {
			this.upLeftCol = col;
		}

		public Integer getUpLeftRow() {
			return upLeftRow;
		}

		public void setUpLeftRow(Integer row) {
			this.upLeftRow = row;
		}

		public Integer getLowRightCol() {
			return lowRightCol;
		}

		public void setLowRightCol(Integer lowRightCol) {
			this.lowRightCol = lowRightCol;
		}

		public Integer getLowRightRow() {
			return lowRightRow;
		}

		public void setLowRightRow(Integer lowRightRow) {
			this.lowRightRow = lowRightRow;
		}

		public Integer getWidth() {
			return width;
		}

		public void setWidth(Integer width) {
			this.width = width;
		}

		public Integer getHeight() {
			return height;
		}

		public void setHeight(Integer height) {
			this.height = height;
		}

		@Override
		public String toString() {
			return "PropertyDescriptor [propertyId=" + propertyId + ", upLeftCol=" + upLeftCol + ", upLeftRow="
					+ upLeftRow + ", lowRightCol=" + lowRightCol + ", lowRightRow=" + lowRightRow + "]";
		}

	}
}
