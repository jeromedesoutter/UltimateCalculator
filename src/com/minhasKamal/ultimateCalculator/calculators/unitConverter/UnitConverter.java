/****************************************************************************************************************
* Developer: Minhas Kamal(BSSE-0509, IIT, DU)																	*
* Date: 04-Jan-2014																								*
* Modified: 01-Jan-2015																							*
****************************************************************************************************************/

package com.minhasKamal.ultimateCalculator.calculators.unitConverter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.minhasKamal.ultimateCalculator.mainFrame.UltimateCalculatorFrame;
import com.minhasKamal.ultimateCalculator.notifications.message.Message;
import com.minhasKamal.ultimateCalculator.utils.fileIO.FileIO;


/**
 * A Unit Converter
 * 
 * @author Minhas Kamal
 */
public class UnitConverter extends UltimateCalculatorFrame{

	//**
	// Variable Declaration 																	#*******D*******#
	//**
	@SuppressWarnings("rawtypes")
	private JComboBox jCBoxTypeSelection;
	@SuppressWarnings("rawtypes")
	private JComboBox[] jComboBoxType;
 
    private JTextField[] jTFieldIO;

	//other variables
    private int SelectedIndex;
    private UnitConverterOperation.UnitConverter[] valuesEnum;
    private int from, to;
    private boolean buttonPressed;
	// End of Variable Declaration 																#_______D_______#

	/***##Constructor##***/
	public UnitConverter() {
		SelectedIndex=1;
		valuesEnum = UnitConverterOperation.Length.values();
		from=1;
		to=1;
		buttonPressed=false;
		
		initialComponent();
		
		super.jCBItemMode[4].setSelected(true);
	}


	/**
	 * Method for Initializing all the GUI variables and placing them all to specific space on 
	 * the frame. It also specifies criteria of the main frame.
	 */
	@SuppressWarnings({ "serial" })
	private void initialComponent() {
		// GUI Initialization
		// GUI Declaration
		UnitConverterGui unitConvgui = new UnitConverterGui();

		//instruction
		try {
			super.instruction = FileIO.readWholeFile(getClass().getResourceAsStream("/res/txts/" +
					"UnitConverterInstruction.txt"));
		} catch (IOException e) {
			super.instruction = "EMPTY";
		}
				
		//**
		// Assignation 																			#*******A*******#
		//**
		jCBoxTypeSelection = unitConvgui.jCBoxTypeSelection; 
		jComboBoxType = unitConvgui.jComboBoxType; 
		
		jTFieldIO = unitConvgui.jTFieldIO;
		JButton jButtonConvert = unitConvgui.jButtonConvert;
		// End of Assignation																	#_______A_______#

		//**
		// Adding Action Events & Other Attributes												#*******AA*******#
		//**
		jCBoxTypeSelection.addActionListener(this::jCBoxTypeSelectionActionPerformed);
		
		jComboBoxType[0].addActionListener(this::jComboBoxTypeFromActionPerformed);
		
		jComboBoxType[1].addActionListener(this::jComboBoxTypeToActionPerformed);
		
		jButtonConvert.addActionListener(evt -> {
			buttonPressed=true;
			jButtonConvertActionPerformed();
			buttonPressed=false;
		});
		jButtonConvert.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).
	    	put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), "ENTER_pressed");
		jButtonConvert.getActionMap().put("ENTER_pressed", new AbstractAction() {
	        public void actionPerformed(ActionEvent evt) {
	        	buttonPressed=true;
            	jButtonConvertActionPerformed();
            	buttonPressed=false;
	        }
	    });
		// End of Adding Action Events & Other Attributes										#_______AA_______#
		
		//setting criterion of the frame
		super.gui.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		super.gui.setTitle("Unit Converter");		
		super.gui.setBounds(230, 115, 350, 400);
		super.gui.add(unitConvgui);
		super.gui.setResizable(false);
		super.gui.setLayout(null);
		super.gui.setFocusable(true);
	}

	//**
	// Action Events 																			#*******AE*******#
	//**
	//Mode
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void jCBoxTypeSelectionActionPerformed(ActionEvent evt){
		SelectedIndex=jCBoxTypeSelection.getSelectedIndex()+1;
		
		if(SelectedIndex==1){
			valuesEnum = UnitConverterOperation.Length.values();
			//Setting types
			jComboBoxType[0].setModel(new DefaultComboBoxModel(new String[] {"Angstrom", "Nanometer", "Micron", 
					"Millimeter", "Centimeter", "Meter", "KiloMeter", "Inch", "Feet", "Yard", "Nautical Mile", "Mile",
					"Rod"}));
			jComboBoxType[1].setModel(new DefaultComboBoxModel(new String[] {"Angstrom", "Nanometer", "Micron", 
					"Millimeter", "Centimeter", "Meter", "KiloMeter", "Inch", "Feet", "Yard", "Nautical Mile", "Mile",
					"Rod"}));
			
		}else if(SelectedIndex==2){
			valuesEnum = UnitConverterOperation.Weight.values();
			//Setting types
			jComboBoxType[0].setModel(new DefaultComboBoxModel(new String[] {"Milligram", "Gram", "Kilogram",
					"Tonne", "Ounce", "Pound", "Carat"}));
			jComboBoxType[1].setModel(new DefaultComboBoxModel(new String[] {"Milligram", "Gram", "Kilogram",
					"Tonne", "Ounce", "Pound", "Carat"}));
			
		}else if(SelectedIndex==3){
			valuesEnum = UnitConverterOperation.Temperature.values();
			//Setting types
			jComboBoxType[0].setModel(new DefaultComboBoxModel(new String[] {"Celsius", "Fahrenheit", "Kelvin"}));
			jComboBoxType[1].setModel(new DefaultComboBoxModel(new String[] {"Celsius", "Fahrenheit", "Kelvin"}));
			
		}else if(SelectedIndex==4){
			//Setting types
			jComboBoxType[0].setModel(new DefaultComboBoxModel(new String[] {"Square Centimeter", "Square Meter",
					"Hectare", "Square Kilometer", "Square Inch", "Square Feet", "Square Yard", "Square Mile", "Katha", 
					"Bigha", "Satak", "Acre"}));
			jComboBoxType[1].setModel(new DefaultComboBoxModel(new String[] {"Square Centimeter", "Square Meter",
					"Hectare", "Square Kilometer", "Square Inch", "Square Feet", "Square Yard", "Square Mile", "Katha", 
					"Bigha", "Satak", "Acre"}));
			
		}else if(SelectedIndex==5){
			valuesEnum = UnitConverterOperation.Volume.values();
			//Setting types
			jComboBoxType[0].setModel(new DefaultComboBoxModel(new String[] {"Cubic Centimeter", "Cubic Meter",
					"Cubic Inch", "Cubic Feet", "Cubic Yard", "Liter", "Gallon(UK)", "Gallon(US)"}));
			jComboBoxType[1].setModel(new DefaultComboBoxModel(new String[] {"Cubic Centimeter", "Cubic Meter",
					"Cubic Inch", "Cubic Feet", "Cubic Yard", "Liter", "Gallon(UK)", "Gallon(US)"}));
			
		}else if(SelectedIndex==6){
			valuesEnum = UnitConverterOperation.Time.values();
			//Setting types
			jComboBoxType[0].setModel(new DefaultComboBoxModel(new String[] {"Nanosecond", "Millisecond", 
					"Second", "Minute", "Hour", "Day" , "Week"}));
			jComboBoxType[1].setModel(new DefaultComboBoxModel(new String[] {"Nanosecond", "Millisecond", 
					"Second", "Minute", "Hour", "Day" , "Week"}));
			
		}else if(SelectedIndex==7){
			valuesEnum = UnitConverterOperation.Energy.values();
			//Setting types
			jComboBoxType[0].setModel(new DefaultComboBoxModel(new String[] {"Joule", "Kilojoule",
					"Calorie", "Kilocalorie", "Electron-Volts", "Foot-Pound"}));
			jComboBoxType[1].setModel(new DefaultComboBoxModel(new String[]{"Joule", "Kilojoule",
					"Calorie", "Kilocalorie", "Electron-Volts", "Foot-Pound"}));


		}else if(SelectedIndex==8){
			valuesEnum = UnitConverterOperation.Power.values();
			//Setting types
			jComboBoxType[0].setModel(new DefaultComboBoxModel(new String[] {"Watt", "Kilowatt",
					"Horsepower" }));
			jComboBoxType[1].setModel(new DefaultComboBoxModel(new String[] {"Watt", "Kilowatt",
					"Horsepower" }));

		}
		
		//initializing
		from=1;
		to=1;
		jTFieldIO[1].setText("");
	}
	
	//Combo Box Item//
	private void jComboBoxTypeFromActionPerformed(ActionEvent evt){
		from=jComboBoxType[0].getSelectedIndex()+1;
		
		jButtonConvertActionPerformed();
	}
	private void jComboBoxTypeToActionPerformed(ActionEvent evt){
		to=jComboBoxType[1].getSelectedIndex()+1;
		
		jButtonConvertActionPerformed();
	}
	
	//Convert Button//
	private void jButtonConvertActionPerformed(){
		try{
			double input=Double.parseDouble(jTFieldIO[0].getText());
			double output=UnitConverterOperation.Convert(valuesEnum[from-1], valuesEnum[to-1], input);

			jTFieldIO[1].setText(output+"");
		}catch(NumberFormatException e){
			if(buttonPressed) new Message("Math Error!\n   Please input correctly.", 420);
			else jTFieldIO[1].setText("");
		}
	}
	
	/********* Main Method *********/
	public static void main(String[] args) {
		/*// Set the NIMBUS look and feel //*/
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException| InstantiationException| IllegalAccessException| UnsupportedLookAndFeelException ex) {
			// do nothing if operation is unsuccessful
		}

		/* Create */
		new UnitConverter();
	}
}
