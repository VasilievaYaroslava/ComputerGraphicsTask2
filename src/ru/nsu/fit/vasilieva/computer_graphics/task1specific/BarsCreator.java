package ru.nsu.fit.vasilieva.computer_graphics.task1specific;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

import ru.nsu.fit.vasilieva.computer_graphics.view.AbstractBarsCreator;

public class BarsCreator implements AbstractBarsCreator
{
	private JMenuBar menubar;
	private JToolBar toolbar;
	
	/**
	 * Constructs a {@link BarsCreator}.
	 * 
	 * @param controller - the {@link MenuController}. Its methods will be called after user's actions.
	 */
	public BarsCreator(final MenuController controller)
	{
		toolbar = new JToolBar("");
		toolbar.setFloatable(false); 
		menubar = new JMenuBar();
		toolbar.setBorderPainted(true);
		menubar.setBorderPainted(true);	
		
		JMenu file = new JMenu("Файл");
		addItem(file, "Выход", "icons/Close.png", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.closeProgram();
				
			}
		});
		
		
		JMenu paint = new JMenu("Рисование");
		addItem(paint, "Квадрат", "icons/SimpleSquare.png", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.drawSimpleSquare();
				
			}
		});
		
		JMenu about = new JMenu("Справка");
		addItem(about, "О программе", "icons/AboutProgram.png", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.aboutProgram();
				
			}
		});
		
		menubar.add(file);
		menubar.add(paint);
		menubar.add(about);
		
		
	}

	@Override
	public JToolBar createToolBar() 
	{
		return toolbar;
	}

	@Override
	public JMenuBar createMenuBar() 
	{
		return menubar;
	}
	
	
	private void  addItem(JMenu parent, String name, String picture, ActionListener l)
	{
		JMenuItem newItem = new JMenuItem(name);
		JButton button = new JButton();
		button.addActionListener(l);
		ImageIcon image = new ImageIcon(getClass().getResource(picture));
		button.setIcon(new ImageIcon(image.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));;
		toolbar.add(button);
		newItem.addActionListener(l);
		parent.add(newItem);
	}

}
