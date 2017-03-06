package network;													/*	Package for class placement	*/
/**
 * This class is a model simulation of the Shannon-Hartley theorem.
 * @author Richard Nguyen
 *@version 1.0.1 Feb, 12, 2017
 */
public class ShannonsModel {
	double bandwidth;
	double signalToNoise;

	/* CONSTRUCTORS	--------------------------------------------------	*/
	/**
	 *	Default constructor.
	 */
	public ShannonsModel()	{		}

	/**
	 *	Parameterized constructor.
	 *	@param	bandwidth bandwidth in hertz.
	 *  @param  signalToNoise signal-to-noise in decibels.
	 */
	public ShannonsModel(double bandwidth, double signalToNoise)	{	
		if (bandwidth > 0 && signalToNoise > 0) {
			setBandwidth(bandwidth);
			setSignalToNoise(signalToNoise);
		}else {
			throw new IllegalArgumentException(); //throw exception if one or more negative numbers are set 
		}
	}

	/* ACCESSORS	-----------------------------------------------------	*/
	/**
	 * Gets the bandwidth.
	 * @return bandwidth in hertz.
	 */
	public double getBandwidth()						{ return bandwidth;		}
	/**
	 * Gets the signal-to-noise ratio.
	 * @return signal-to-noise in decibels.
	 */
	public double getSignalToNoise()						{ return signalToNoise;		}
	/**
	 * Gets the max data rate capacity.
	 * @return the max data rate in bps. 
	 */
	public double getMaxDataRate()						{ return getMaxDataRate(getBandwidth(), getSignalToNoise());}
	/**
	 *  A parameterized method that gets the max data rate capacity.
	 *  @param bandwidth the bandwidth in hertz.
	 *  @param signalToNoise the signal-to-noise in decibels.
	 *  @return the max data rate in bps.
	 */
	public double getMaxDataRate(double bandwidth, double signalToNoise)	{
		if (bandwidth > 0 && signalToNoise > 0) {
			return (bandwidth * (Math.log(1 + Math.pow(10, signalToNoise/10.0))/Math.log(2)));
		}else {
			throw new IllegalArgumentException(); //throw exception if one or more negative numbers are set 
		}

	}

	/* MODIFIERS	-----------------------------------------------------	*/
	/**
	 *  Sets the bandwidth.
	 *  @param bandwidth bandwidth in hertz.
	 */
	public void setBandwidth(double bandwidth) { 
		if (bandwidth > 0) {
			this.bandwidth = bandwidth;	
		}else {
			throw new IllegalArgumentException(); //throw exception if negative number is set 
		}
	}
	/**
	 *  Sets the signal-to-noise ratio.
	 *  @param signalToNoise signal-to-noise in decibels.
	 */
	public void setSignalToNoise(double signalToNoise) { 
		if (signalToNoise > 0) {
			this.signalToNoise = signalToNoise;
		}else {
			throw new IllegalArgumentException();  //throw exception if negative number is set 
		}
	}

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

}
