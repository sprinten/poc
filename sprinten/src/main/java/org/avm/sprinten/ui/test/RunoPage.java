package org.avm.sprinten.ui.test;

import java.util.Date;
import java.util.Iterator;

import org.avm.framework.ui.navigation.Navigable;
import org.avm.sprinten.ui.main.MainWindow;
import org.avm.sprinten.ui.pages.NavigablePage;
import org.vaadin.navigator7.Navigator.NavigationEvent;
import org.vaadin.navigator7.Page;

import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.DateField;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Slider;
import com.vaadin.ui.Slider.ValueOutOfBoundsException;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.TwinColSelect;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window.Notification;
import com.vaadin.ui.themes.Runo;

@SuppressWarnings("serial")
@Page(uriName = "runo")
public class RunoPage extends Panel implements NavigablePage, Navigable {

	@SuppressWarnings("deprecation")
	private static final Date DATEFIELD_VALUE = new Date(2010 - 1900, 7 - 1, 19, 14, 46, 00);
	private TabSheet main = new TabSheet();
	private TabSheet styles = new TabSheet();

	public RunoPage() {
		super("Runo - Aspect");
		VerticalLayout root = new VerticalLayout();
		root.setMargin(true);
		root.setSizeFull();

		Label title = new Label("Vaadin Runo Theme");
		title.addStyleName(Runo.LABEL_H1);
		title.setSizeUndefined();
		root.addComponent(title);
		root.setComponentAlignment(title, Alignment.MIDDLE_CENTER);

		Label slogan = new Label("Presenting a Stylish Alternative for the Traditional Desktop-Look");
		slogan.addStyleName(Runo.LABEL_SMALL);
		slogan.setSizeUndefined();
		root.addComponent(slogan);
		root.setComponentAlignment(slogan, Alignment.MIDDLE_CENTER);

		Label spacer = new Label("");
		spacer.setHeight("20px");
		root.addComponent(spacer);

		main.setSizeFull();

		main.addTab(buildWelcomeScreen(), "Welcome", null);
		main.addTab(buildStyleReference(), "Style Reference", null);

		setContent(root);
	}

	private Layout buildWelcomeScreen() {
		VerticalLayout l = new VerticalLayout();
		l.setSizeFull();
		l.setCaption("Welcome");

		Panel welcome = new Panel("Runo Theme");
		welcome.setSizeFull();
		welcome.addStyleName(Runo.PANEL_LIGHT);
		l.addComponent(welcome);
		l.setExpandRatio(welcome, 1);

		CssLayout margin = new CssLayout();
		margin.setMargin(true);
		margin.setWidth("100%");
		welcome.setContent(margin);

		Label title = new Label("Runo Theme");
		title.addStyleName(Runo.LABEL_H1);
		// margin.addComponent(title);

		HorizontalLayout texts = new HorizontalLayout();
		texts.setSpacing(true);
		texts.setWidth("100%");
		margin.addComponent(texts);

		Label text = new Label(
				"<h3>A Complete Theme</h3><p>The Runo theme is a complete, general purpose theme suitable for many types of applications.</p><p>The name Runo is a Finnish word, meaning \"a poem\" in English. It is also used to refer to a very particular kind of female reindeer.</p>",
				Label.CONTENT_XHTML);
		texts.addComponent(text);
		texts.setExpandRatio(text, 1);

		// Spacer
		text = new Label("");
		text.setWidth("20px");
		texts.addComponent(text);

		text = new Label(
				"<h3>Everything You Need Is Here</h3><p>Everything you see inside this application, all the different styles, are provided by the Runo theme, out-of-the-box. That means you don't necessarily need to create any custom CSS for your application: you can build a cohesive result writing plain Java code.</p><p>A little creativity, good organization and careful typography carries a long way.</p>",
				Label.CONTENT_XHTML);
		texts.addComponent(text);
		texts.setExpandRatio(text, 1);

		// Spacer
		text = new Label("");
		text.setWidth("20px");
		texts.addComponent(text);

		text = new Label(
				"<h3>The Names of The Styles</h3><p>Look for a class named <code>Runo</code> inside the Vaadin JAR (<code>com.vaadin.ui.themes.Runo</code>).</p><p>All the available style names are documented and available there as constants, prefixed by component names, e.g. <code>Runo.BUTTON_SMALL</code>.</p>",
				Label.CONTENT_XHTML);
		texts.addComponent(text);
		texts.setExpandRatio(text, 1);

		l.addComponent(new Label("<hr />", Label.CONTENT_XHTML));

		texts = new HorizontalLayout();
		texts.addStyleName(Runo.LAYOUT_DARKER);
		texts.setSpacing(true);
		texts.setWidth("100%");
		texts.setMargin(true);
		l.addComponent(texts);

		text = new Label(
				"<h4>About This Application</h4>In addition to this welcome screen, you'll find the style name reference and sample views within the two other main tabs.",
				Label.CONTENT_XHTML);
		text.addStyleName(Runo.LABEL_SMALL);
		texts.addComponent(text);
		texts.setExpandRatio(text, 1);

		// Spacer
		text = new Label("");
		text.setWidth("20px");
		texts.addComponent(text);

		Button next = new Button("View Samples >>", new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
			}
		});
		next.setWidth("100%");
		next.addStyleName(Runo.BUTTON_DEFAULT);
		next.addStyleName(Runo.BUTTON_BIG);
		texts.addComponent(next);
		texts.setComponentAlignment(next, Alignment.BOTTOM_LEFT);
		texts.setExpandRatio(next, 1);

		// Spacer
		text = new Label("");
		text.setWidth("20px");
		texts.addComponent(text);

		next = new Button("Style Reference >>", new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				main.setSelectedTab(styles);
			}
		});
		next.setWidth("100%");
		next.addStyleName(Runo.BUTTON_DEFAULT);
		next.addStyleName(Runo.BUTTON_BIG);
		texts.addComponent(next);
		texts.setComponentAlignment(next, Alignment.BOTTOM_LEFT);
		texts.setExpandRatio(next, 1);

		return l;
	}

	private ComponentContainer buildStyleReference() {
		styles.addStyleName(Runo.TABSHEET_SMALL);
		styles.setSizeFull();

		styles.addTab(buildLabels());
		styles.addTab(buildButtons());
		styles.addTab(buildTextFields());
		styles.addTab(buildSelects());
		styles.addTab(buildDateFields());
		styles.addTab(buildSliders());
		styles.addTab(buildTabSheets());
		styles.addTab(buildAccordions());
		styles.addTab(buildPanels());
		styles.addTab(buildSplitPanels());
		styles.addTab(buildTables());
		styles.addTab(buildNotifications());
		styles.addTab(buildLayouts());

		return styles;
	}

	private Layout buildLabels() {
		GridLayout l = new GridLayout(2, 1);
		l.setWidth("560px");
		l.setSpacing(true);
		l.setMargin(true);
		l.setCaption("Labels");

		l.addComponent(new Label("Header Style (<code>Runo.LABEL_H1</code>)", Label.CONTENT_XHTML));
		Label label = new Label("Lorem Ipsum");
		label.addStyleName(Runo.LABEL_H1);
		l.addComponent(label);

		l.addComponent(new Label("Sub-header Style (<code>Runo.LABEL_H2</code>)", Label.CONTENT_XHTML));
		label = new Label("Lorem Ipsum Dolor");
		label.addStyleName(Runo.LABEL_H2);
		l.addComponent(label);

		l.addComponent(new Label("Normal Label", Label.CONTENT_XHTML));
		l.addComponent(new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit."));

		l.addComponent(new Label("Small Style (<code>Runo.LABEL_SMALL</code>)", Label.CONTENT_XHTML));
		label = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		label.addStyleName(Runo.LABEL_SMALL);
		l.addComponent(label);

		return l;
	}

	private Layout buildButtons() {
		GridLayout l = new GridLayout(2, 1);
		l.setCaption("Buttons");
		l.setMargin(true);
		l.setSpacing(true);
		l.setWidth("500px");
		l.setColumnExpandRatio(0, 1);

		l.addComponent(new Label("Normal Button", Label.CONTENT_XHTML));

		Button b = new Button("Normal Button");
		l.addComponent(b);

		l.addComponent(new Label("\"Default\" Style<br />(<code>Runo.BUTTON_DEFAULT</code>)", Label.CONTENT_XHTML));

		b = new Button("Default Button");
		b.setStyleName(Runo.BUTTON_DEFAULT);
		l.addComponent(b);

		l.addComponent(new Label("Big Style<br />(<code>Runo.BUTTON_BIG</code>)", Label.CONTENT_XHTML));
		b = new Button("Big Button");
		b.setStyleName(Runo.BUTTON_BIG);
		l.addComponent(b);

		l.addComponent(new Label("Big Default<br />(<code>Runo.BUTTON_BIG & Runo.BUTTON_DEFAULT</code>)", Label.CONTENT_XHTML));
		b = new Button("Big Default");
		b.setStyleName(Runo.BUTTON_BIG);
		b.addStyleName(Runo.BUTTON_DEFAULT);
		l.addComponent(b);

		l.addComponent(new Label("Small Style<br />(<code>Runo.BUTTON_SMALL</code>)", Label.CONTENT_XHTML));

		b = new Button("Small Button");
		b.setStyleName(Runo.BUTTON_SMALL);
		l.addComponent(b);
		l.addComponent(new Label("Small Default<br />(<code>Runo.BUTTON_SMALL & Runo.BUTTON_DEFAULT</code>)", Label.CONTENT_XHTML));

		b = new Button("Small Default");
		b.setStyleName(Runo.BUTTON_SMALL);
		b.addStyleName(Runo.BUTTON_DEFAULT);
		l.addComponent(b);
		l.addComponent(new Label("Disabled Button<br />(<code>Button.setEnabled(false)</code>)", Label.CONTENT_XHTML));
		b = new Button("Disabled Button");
		b.setEnabled(false);
		l.addComponent(b);

		l.addComponent(new Label("Link Style<br />(<code>Runo.BUTTON_LINK</code>)", Label.CONTENT_XHTML));
		b = new Button("Link Button");
		b.setStyleName(Runo.BUTTON_LINK);
		l.addComponent(b);

		return l;
	}

	private Layout buildTextFields() {
		GridLayout l = new GridLayout(2, 1);
		l.setCaption("Text fields");
		l.setMargin(true);
		l.setSpacing(true);
		l.setWidth("400px");
		l.setColumnExpandRatio(0, 1);

		l.addComponent(new Label("Normal TextField", Label.CONTENT_XHTML));
		TextField tf = new TextField();
		tf.setInputPrompt("Enter text");
		l.addComponent(tf);

		l.addComponent(new Label("Small Style (<code>Runo.TEXTFIELD_SMALL</code>)", Label.CONTENT_XHTML));

		tf = new TextField();
		tf.setStyleName(Runo.TEXTFIELD_SMALL);
		tf.setInputPrompt("Enter text");
		l.addComponent(tf);

		l.addComponent(new Label("Normal TextArea", Label.CONTENT_XHTML));

		tf = new TextField();
		tf.setHeight("5em");
		tf.setInputPrompt("Enter text");
		l.addComponent(tf);

		l.addComponent(new Label("Small Style TextArea (<code>Runo.TEXTFIELD_SMALL</code>)", Label.CONTENT_XHTML));

		tf = new TextField();
		tf.setHeight("5em");
		tf.setStyleName(Runo.TEXTFIELD_SMALL);
		tf.setInputPrompt("Enter text");
		l.addComponent(tf);

		return l;
	}

	private Layout buildSelects() {
		VerticalLayout l = new VerticalLayout();
		l.setCaption("Selects");
		l.setMargin(true);
		l.setSpacing(true);

		l.addComponent(new Label("Selects don't currently have any additional style names."));

		HorizontalLayout hl = new HorizontalLayout();
		hl.setSpacing(true);
		hl.setMargin(true, false, false, false);
		l.addComponent(hl);

		AbstractSelect cb = new ComboBox();
		AbstractSelect nat = new NativeSelect();
		AbstractSelect list = new ListSelect();
		AbstractSelect twincol = new TwinColSelect();

		for (int i = 0; i < 25; i++) {
			cb.addItem("Item " + i);
			nat.addItem("Item " + i);
			list.addItem("Item " + i);
			twincol.addItem("Item " + i);
		}

		hl.addComponent(cb);
		hl.addComponent(nat);
		hl.addComponent(list);
		hl.addComponent(twincol);

		return l;
	}

	private Layout buildDateFields() {
		VerticalLayout l = new VerticalLayout();
		l.setCaption("Date fields");
		l.setMargin(true);
		l.setSpacing(true);

		l.addComponent(new Label("Date fields don't currently have any additional style names."));

		HorizontalLayout hl = new HorizontalLayout();
		hl.setSpacing(true);
		hl.setMargin(true, false, false, false);
		l.addComponent(hl);

		DateField df = new DateField();
		df.setValue(DATEFIELD_VALUE);
		df.setResolution(DateField.RESOLUTION_MIN);
		hl.addComponent(df);

		df = new InlineDateField();
		df.setValue(DATEFIELD_VALUE);
		df.setResolution(DateField.RESOLUTION_DAY);
		hl.addComponent(df);

		df = new InlineDateField();
		df.setValue(DATEFIELD_VALUE);
		df.setResolution(DateField.RESOLUTION_YEAR);
		hl.addComponent(df);

		return l;
	}

	private Layout buildTabSheets() {
		GridLayout l = new GridLayout(2, 1);
		l.setCaption("Tabs");
		l.setMargin(true);
		l.setSpacing(true);
		l.setWidth("700px");
		l.setColumnExpandRatio(0, 3);
		l.setColumnExpandRatio(1, 5);

		HorizontalLayout checks = new HorizontalLayout();
		checks.setSpacing(true);

		CheckBox closable = new CheckBox("Closable tabs");
		closable.setImmediate(true);
		checks.addComponent(closable);

		l.addComponent(checks, 1, 0);
		l.setCursorX(0);
		l.setCursorY(1);

		l.addComponent(new Label("Normal Tabs", Label.CONTENT_XHTML));

		final TabSheet ts = new TabSheet();
		ts.setHeight("100px");
		l.addComponent(ts);

		l.addComponent(new Label("Small Style (<code>Runo.TABSHEET_SMALL</code>)", Label.CONTENT_XHTML));

		final TabSheet ts2 = new TabSheet();
		ts2.setStyleName(Runo.TABSHEET_SMALL);
		l.addComponent(ts2);

		for (int i = 1; i < 10; i++) {
			ts.addTab(new Label(), "Tab " + i, null);
			ts2.addTab(new Label(), "Tab " + i, null);
		}

		closable.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				Iterator<Component> it = ts.getComponentIterator();
				Iterator<Component> it2 = ts2.getComponentIterator();
				for (; it.hasNext();) {
					Component c = (Component) it.next();
					ts.getTab(c).setClosable(event.getButton().booleanValue());
				}
				for (; it2.hasNext();) {
					Component c = (Component) it2.next();
					ts2.getTab(c).setClosable(event.getButton().booleanValue());
				}
			}
		});

		return l;
	}

	private Layout buildPanels() {
		GridLayout l = new GridLayout(2, 1);
		l.setCaption("Panels");
		l.setMargin(true);
		l.setSpacing(true);
		l.setWidth("700px");
		l.setColumnExpandRatio(0, 2);
		l.setColumnExpandRatio(1, 5);

		l.addComponent(new Label("Normal Panel", Label.CONTENT_XHTML));

		Panel p = new Panel("Normal Panel");
		p.addComponent(new Label("Panel content"));
		l.addComponent(p);

		l.addComponent(new Label("Light Style (<code>Runo.PANEL_LIGHT</code>)", Label.CONTENT_XHTML));

		Panel p2 = new Panel("Light Style Panel");
		p2.setStyleName("light");
		p2.addComponent(new Label("Panel content"));
		l.addComponent(p2);

		return l;
	}

	private Layout buildTables() {
		GridLayout l = new GridLayout(2, 1);
		l.setCaption("Tables");
		l.setMargin(true);
		l.setSpacing(true);
		l.setWidth("700px");
		l.setColumnExpandRatio(0, 3);
		l.setColumnExpandRatio(1, 5);

		for (int i = 0; i < 4; i++) {

			Table t = new Table();
			t.setWidth("100%");
			t.setPageLength(3);
			t.setSelectable(true);
			t.setColumnCollapsingAllowed(true);
			t.setColumnReorderingAllowed(true);

			if (i == 2) {
				t.setStyleName(Runo.TABLE_SMALL);
				l.addComponent(new Label("Small Style (<code>Runo.TABLE_SMALL</code>)", Label.CONTENT_XHTML));
			} else if (i == 1) {
				t.setStyleName(Runo.TABLE_BORDERLESS);
				l.addComponent(new Label("Borderless Style (<code>Runo.TABLE_BORDERLESS</code>)", Label.CONTENT_XHTML));
			} else if (i == 3) {
				t.setStyleName(Runo.TABLE_BORDERLESS);
				t.addStyleName(Runo.TABLE_SMALL);
				l.addComponent(new Label("Borderless & Small (<code>Runo.TABLE_BORDERLESS & Runo.TABLE_SMALL</code>)", Label.CONTENT_XHTML));
			} else {
				l.addComponent(new Label("Normal Table", Label.CONTENT_XHTML));
			}

			t.addContainerProperty("First", String.class, null);
			t.addContainerProperty("Second", String.class, null);
			t.addContainerProperty("Third", String.class, null);

			for (int j = 0; j < 100; j++) {
				t.addItem(new Object[] { "Foo " + j, "Bar value " + j, "Last column value " + j }, j);
			}

			l.addComponent(t);
		}
		return l;
	}

	private Layout buildSplitPanels() {
		final GridLayout l = new GridLayout(2, 1);
		l.setCaption("Split panels");
		l.setMargin(true);
		l.setSpacing(true);
		l.setWidth("400px");
		l.setColumnExpandRatio(0, 1);

		HorizontalLayout checks = new HorizontalLayout();
		checks.setSpacing(true);

		CheckBox locked = new CheckBox("Locked");
		locked.setDescription("Prevent split dragging");
		locked.setImmediate(true);
		checks.addComponent(locked);

		l.addComponent(checks, 1, 0);
		l.setCursorX(0);
		l.setCursorY(1);

		l.addComponent(new Label("Normal SplitPanel", Label.CONTENT_XHTML));

		final HorizontalSplitPanel sp = new HorizontalSplitPanel();
		sp.setWidth("100px");
		sp.setHeight("120px");
		l.addComponent(sp);

		l.addComponent(new Label("Reduced Style (<code>Runo.SPLITPANEL_REDUCED</code>)", Label.CONTENT_XHTML));

		final HorizontalSplitPanel sp2 = new HorizontalSplitPanel();
		sp2.setStyleName(Runo.SPLITPANEL_REDUCED);
		sp2.setWidth("100px");
		sp2.setHeight("120px");
		l.addComponent(sp2);

		l.addComponent(new Label("Small Style (<code>Runo.SPLITPANEL_SMALL</code>)", Label.CONTENT_XHTML));

		final HorizontalSplitPanel sp3 = new HorizontalSplitPanel();
		sp3.setStyleName(Runo.SPLITPANEL_SMALL);
		sp3.setWidth("100px");
		sp3.setHeight("120px");
		l.addComponent(sp3);

		locked.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				sp.setLocked(event.getButton().booleanValue());
				sp2.setLocked(event.getButton().booleanValue());
				sp3.setLocked(event.getButton().booleanValue());
			}
		});

		return l;
	}

	private Layout buildAccordions() {
		final GridLayout l = new GridLayout(2, 1);
		l.setCaption("Accordions");
		l.setMargin(true);
		l.setSpacing(true);
		l.setWidth("600px");
		l.setColumnExpandRatio(0, 1);
		l.setColumnExpandRatio(1, 2);

		l.addComponent(new Label("Normal Accordion", Label.CONTENT_XHTML));
		Accordion a = new Accordion();
		a.setWidth("100%");
		a.setHeight("170px");
		l.addComponent(a);

		l.addComponent(new Label("Light Style<br />(<code>Runo.ACCORDION_LIGHT</code>)", Label.CONTENT_XHTML));
		Accordion a2 = new Accordion();
		a2.setWidth("100%");
		a2.setHeight("170px");
		a2.addStyleName(Runo.ACCORDION_LIGHT);
		l.addComponent(a2);

		for (int i = 1; i < 4; i++) {
			a.addTab(new Label(), "Sheet " + i, null);
			a2.addTab(new Label(), "Sheet " + i, null);
		}

		return l;
	}

	private Layout buildSliders() {
		final GridLayout l = new GridLayout(2, 1);
		l.setCaption("Sliders");
		l.setMargin(true);
		l.setSpacing(true);
		l.setWidth("400px");
		l.setColumnExpandRatio(0, 1);

		l.addComponent(new Label("Normal Slider", Label.CONTENT_XHTML));
		Slider s = new Slider();
		s.setWidth("200px");
		try {
			s.setValue(50);
		} catch (ValueOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l.addComponent(s);

		return l;
	}

	private 	Layout buildNotifications() {
		final GridLayout l = new GridLayout(2, 1);
		l.setCaption("Notifications");
		l.setMargin(true);
		l.setSpacing(true);
		l.setWidth("400px");
		l.setColumnExpandRatio(0, 1);

		final TextField title = new TextField("Notification caption");
		title.setValue("Brown Fox!");
		final TextField message = new TextField("Notification description");
		message.setValue("Jumped over the lazy dog.");
		message.setWidth("15em");

		l.addComponent(new Label("<h3>Type</h3>", Label.CONTENT_XHTML));
		l.addComponent(new Label("<h3>Preview</h3>", Label.CONTENT_XHTML));

		l.addComponent(new Label("Humanized", Label.CONTENT_XHTML));
		Button show = new Button("Humanized Notification", new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				event.getButton().getWindow().showNotification((String) title.getValue(), (String) message.getValue());

			}
		});
		l.addComponent(show);

		l.addComponent(new Label("Warning", Label.CONTENT_XHTML));
		show = new Button("Warning Notification", new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				event.getButton().getWindow().showNotification((String) title.getValue(), (String) message.getValue(), Notification.TYPE_WARNING_MESSAGE);

			}
		});
		l.addComponent(show);

		l.addComponent(new Label("Error", Label.CONTENT_XHTML));
		show = new Button("Error Notification", new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				event.getButton().getWindow().showNotification((String) title.getValue(), (String) message.getValue(), Notification.TYPE_ERROR_MESSAGE);

			}
		});
		l.addComponent(show);

		l.addComponent(new Label("Tray", Label.CONTENT_XHTML));
		show = new Button("Tray Notification", new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				event.getButton().getWindow().showNotification((String) title.getValue(), (String) message.getValue(), Notification.TYPE_TRAY_NOTIFICATION);

			}
		});
		l.addComponent(show);

		l.addComponent(title);
		l.addComponent(message);

		return l;
	}

	private Layout buildLayouts() {
		final GridLayout l = new GridLayout(2, 1);
		l.setCaption("Layouts");
		l.setMargin(true);
		l.setSpacing(true);
		l.setWidth("550px");
		l.setColumnExpandRatio(0, 1);

		l.addComponent(new Label("Box Shadow<br />(<code>Runo.CSSLAYOUT_SHADOW</code>)", Label.CONTENT_XHTML));
		CssLayout layout = new CssLayout();
		layout.addStyleName(Runo.CSSLAYOUT_SHADOW);
		Label text = new Label("Content");
		text.setSizeUndefined();
		VerticalLayout align = new VerticalLayout();
		align.addStyleName(Runo.LAYOUT_DARKER);
		align.setWidth("100px");
		align.setHeight("100px");
		align.addComponent(text);
		align.setComponentAlignment(text, Alignment.MIDDLE_CENTER);
		layout.addComponent(align);
		l.addComponent(layout);

		l.addComponent(new Label("Selectable<br />(<code>Runo.CSSLAYOUT_SELECTABLE</code> & <code>Runo.CSSLAYOUT_SELECTABLE_SELECTED</code>)",
				Label.CONTENT_XHTML));
		layout = new CssLayout();
		layout.addStyleName(Runo.CSSLAYOUT_SELECTABLE);
		layout.addStyleName(Runo.CSSLAYOUT_SELECTABLE_SELECTED);
		layout.addListener(new LayoutClickListener() {
			public void layoutClick(LayoutClickEvent event) {
				if (event.getComponent().getStyleName().contains(Runo.CSSLAYOUT_SELECTABLE_SELECTED)) {
					event.getComponent().removeStyleName(Runo.CSSLAYOUT_SELECTABLE_SELECTED);
				} else {
					event.getComponent().addStyleName(Runo.CSSLAYOUT_SELECTABLE_SELECTED);
				}
			}
		});
		text = new Label("Click here");
		text.setSizeUndefined();
		align = new VerticalLayout();
		align.setWidth("100px");
		align.setHeight("100px");
		align.addComponent(text);
		align.setComponentAlignment(text, Alignment.MIDDLE_CENTER);
		layout.addComponent(align);
		l.addComponent(layout);

		return l;
	}

	public void paramChanged(NavigationEvent navigationEvent) {
		// TODO: To Implement
		// Do nothing
	}

	public String extraValidate(String fragment) {
		// TODO: To Implement
		// Do nothing
		return null;
	}

	public void navigateTo(String tabName) {
		((MainWindow) getApplication().getMainWindow()).navigateTo(tabName);
	}

	public void navigateTo(Component pageParam) {
		((MainWindow) getApplication().getMainWindow()).navigateTo(pageParam);
	}
}