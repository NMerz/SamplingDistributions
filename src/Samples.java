import java.util.ArrayList;
import java.util.Random;

public class Samples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int genMean = 100;
		int genStd = 15;
		int samples = 200;
		double value = -100000;
		Random r = new Random();
		int totalMeanAbove = 0;
		int totalStdAbove = 0;
		for(int repeater = 0; repeater <100; repeater++){
			ArrayList<Double> means = new ArrayList<Double>();
			double subTotal = 0;
			double total = 0;
			double totalMean = 0; 
			for(int outerCounter = 0; outerCounter < samples; outerCounter++){
				for (int counter = 0; counter < n; counter ++){
					value = r.nextGaussian()*genStd + genMean;
					subTotal += value;
				}
				total += subTotal/n;
				//System.out.println(subTotal/n);
				means.add(subTotal/n);
				subTotal = 0;
			}
			totalMean = total/samples;
			int stdTotal = 0;
			System.out.println(means.size());
			for (Double x : means){
				stdTotal+=Math.pow((x-totalMean), 2);
			}
			double std = Math.pow((stdTotal/samples),.5);
			//System.out.println(totalMean);
			//System.out.println(std);
			if (totalMean>100){
				totalMeanAbove++;
			} else if (totalMean<100){
				totalMeanAbove--;
			}
			System.out.println(genStd/Math.pow(n, .5));
			System.out.println(std);
			if (std>genStd/Math.pow(n, .5)) {

				totalStdAbove++;
			} else if (std<genStd/Math.pow(n, .5)){
				totalStdAbove--;
			}
		}
		System.out.println(totalMeanAbove);
		System.out.println(totalStdAbove);
	}

}
