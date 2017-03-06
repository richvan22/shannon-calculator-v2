
package network;													/*	Package for class placement	*/

import javax.swing.JOptionPane;

/**
 * This class implements the Shannon-Hartley Theorem, used to compute the Capacity(maximum data rate) of a communications channel.
 * The main program takes in two inputs from the user - the bandwidth and signal-to-noise ratio. The results of the calculation
 *  display after receiving all valid inputs.
 * @author    Richard Nguyen Feb, 12, 2017
 * @version   1.0.1
 */
public class ShannonsTheorem	{
	ShannonsModel model = new ShannonsModel();
	/* CONSTRUCTORS	--------------------------------------------------	*/
	/**
	 *	Default constructor.
	 */
	public ShannonsTheorem()	{		}

	/**
	 *	Parameterized constructor.
	 *	@param	bandwidth bandwidth in hertz.
	 *  @param  signalToNoise signal-to-noise in decibels.
	 */
	public ShannonsTheorem(double bandwidth, double signalToNoise)	{		
		setBandwidth(bandwidth);
		setSignalToNoise(signalToNoise);
	}

	/* ACCESSORS	-----------------------------------------------------	*/
	/**
	 * Gets the bandwidth from the model.
	 * @return bandwidth in hertz.
	 */
	public double getBandwidth()						{ return model.getBandwidth();		}
	/**
	 * Gets the signal-to-noise ratio from the model.
	 * @return signal-to-noise in decibels.
	 */
	public double getSignalToNoise()						{ return model.getSignalToNoise();		}
	/**
	 * Gets the max data rate capacity from the model.
	 * @return the max data rate in bps. 
	 */
	public double getMaxDataRate()						{ return model.getMaxDataRate();}
	/**
	 *  A parameterized method that gets the max data rate capacity from the model.
	 *  @param bandwidth the bandwidth in hertz.
	 *  @param signalToNoise the signal-to-noise in decibels.
	 *  @return the max data rate in bps.
	 */
	public double getMaxDataRate(double bandwidth, double signalToNoise){ 
		return model.getMaxDataRate(bandwidth, signalToNoise);}

	/* MODIFIERS	-----------------------------------------------------	*/
	/**
	 *  Sets the bandwidth for the model.
	 *  @param bandwidth bandwidth in hertz.
	 */
	public void setBandwidth(double bandwidth)						{ model.setBandwidth(bandwidth);	}
	/**
	 *  Sets the signal-to-noise ratio for the model.
	 *  @param signalToNoise signal-to-noise in decibels.
	 */
	public void setSignalToNoise(double signalToNoise)						{ model.setSignalToNoise(signalToNoise);	}

	/*	NORMAL BEHAVIOR -------------------------------------------------	*/
	/**
	 *	Convert this class to a meaningful string.
	 *	@return	The user inputs and result as a meaningful string.
	 */
	@Override
	public String toString()	{
		return	"[" + "Bandwidth: " + getBandwidth() + "hz  " 
				+ "Signal-to-Noise Ratio: " + getSignalToNoise() + "db  "
				+ "Maximum Data Rate: " + getMaxDataRate() + "bps" + "]";
	}

	/*	ENTRY POINT for STAND-ALONE OPERATION ---------------------------	*/
	/**
	 * Entry point "main()" as required by the JVM.
	 * @param  args   Standard command line parameters (arguments) as a
	 *	string array.
	 */
	public static void main (String args[]) {
		int startUp;
		int reRun;
		boolean noError;
		ShannonsTheorem app = new ShannonsTheorem();	
		String bandWidthStr;
		String signalToNoiseStr;


		startUp = JOptionPane.showConfirmDialog(null, "Welcome. Would you like to calculate the maximum data rate for a given channel?", "Shannon's Theorem Calculator", JOptionPane.YES_NO_OPTION);
		if (startUp == JOptionPane.YES_OPTION) {
			do{
				do{
					noError = false; 
					try {
						bandWidthStr = JOptionPane.showInputDialog(null,"Enter bandwidth.", "Bandwidth Input", JOptionPane.QUESTION_MESSAGE);
						if (bandWidthStr == null) {
							System.exit(0);
						}

						app.setBandwidth(Double.parseDouble(bandWidthStr)); //parse then set user's bandwidth input				
						noError = true;
					}catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "Please enter a valid bandwidth.", "Number Format Error", JOptionPane.ERROR_MESSAGE);
					}catch (IllegalArgumentException iae) {
						JOptionPane.showMessageDialog(null, "The bandwidth must be greater than 0.", "Negative Number Error", JOptionPane.ERROR_MESSAGE);
					}
				}while (!noError); //loop while error exists

				do{
					noError = false;
					try {
						signalToNoiseStr = JOptionPane.showInputDialog(null,"Enter signal-to-noise ratio.", "Signal-to-Noise Input", JOptionPane.QUESTION_MESSAGE);
						if (signalToNoiseStr == null) {								
							System.exit(0);
						}
						app.setSignalToNoise(Double.parseDouble(signalToNoiseStr)); //parse then set user's signal-to-noise input						
						noError = true;
					}catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "Please enter valid Signal-to-Noise ratio.", "Number Format Error", JOptionPane.ERROR_MESSAGE);
					}catch (IllegalArgumentException iae) {
						JOptionPane.showMessageDialog(null, "The signal-to-noise ratio must be greater than 0.", "Negative Number Error", JOptionPane.ERROR_MESSAGE);
					}
				}while (!noError); //loop while error exists

				JOptionPane.showMessageDialog(null, app.toString(), "Result", JOptionPane.PLAIN_MESSAGE);
				reRun = JOptionPane.showConfirmDialog(null, "Would you like to perform another calculation?", "Rerun", JOptionPane.YES_NO_OPTION);
			}while (reRun == JOptionPane.YES_OPTION); //loop if user chooses to perform another calculation
		}else {
			System.exit(0);
		}
	}
}	/*	End of CLASS:	ShannonsTheorem.java			*/