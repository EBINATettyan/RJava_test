package estimate;

import java.util.ArrayList;

import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;

public class rJava {
	public rJava() {

	}

	public double test() {
		// Rengine engine = new Rengine(new String[] { "--no-save" }, false,
		// null);
		Rengine engine = Rengine.getMainEngine();
		if (engine == null)
			engine = new Rengine(new String[] { "--vanilla" }, false, null);
		engine.assign("a", new int[] { 81 });
		REXP result = engine.eval("sqrt(a)");
		engine.end();
		return result.asDouble();
	}

	public void test2() {
		// Rengine engine = new Rengine(new String[] { "--no-save" }, false,
		// null);
		Rengine engine = Rengine.getMainEngine();
		if (engine == null)
			engine = new Rengine(new String[] { "--vanilla" }, false, null);
		engine.assign("a", new int[] { 5, 5, 6, 4 });
		engine.eval("b <- mean(a)");
		@SuppressWarnings("unused")
		REXP result;
		engine.eval("sqrt(b)");
		engine.eval("f <- function(x) {return(x * x)}");
		result = engine.eval("f(10)");
		engine.end();
	}

	public void eval() {
		@SuppressWarnings("unused")
		REXP result;
		// Rengine engine = new Rengine(new String[] { "--no-save" }, false,
		// null);
		Rengine engine = Rengine.getMainEngine();
		if (engine == null)
			engine = new Rengine(new String[] { "--vanilla" }, false, null);
		engine.eval("a <- numeric(5)");
		engine.eval("x <- 1:5");
		result = engine.eval("for(i in x) eval(parse(text=paste('a[',i,'] <- 10', sep='') ))");
		result = engine.eval("(a)");
		engine.end();
	}

	public String ltm() {
		REXP result;
		// Rengine engine = new Rengine(new String[] { "--no-save" }, false,
		// null);
		Rengine engine = Rengine.getMainEngine();
		if (engine == null)
			engine = new Rengine(new String[] { "--vanilla" }, false, null);
		engine.eval("library(ltm)");
		engine.eval("data(Science)");
		engine.eval("testset <- Science[c(1, 3, 4, 7)]");
		result = engine.eval("grm(testset)");
		engine.end();
		return String.valueOf(result);
	}

	public double sqrt(int _num) {
		// Rengine engine = new Rengine(new String[] { "--no-save" }, false,
		// null);
		Rengine engine = Rengine.getMainEngine();
		if (engine == null)
			engine = new Rengine(new String[] { "--vanilla" }, false, null);
		engine.assign("a", new int[] { _num });
		REXP result = engine.eval("sqrt(a)");
		double res = result.asDouble();
		engine.end();
		return res;
	}

	public ArrayList<Double> estimateTheta() {
		// Rengine re = new Rengine(new String[] { "--no-save" }, false, null);
		Rengine re = Rengine.getMainEngine();
		if (re == null)
			re = new Rengine(new String[] { "--vanilla" }, false, null);
		re.eval(" library(irtoys) ");
		re.eval(" library(ltm) ");
		re.eval("data <- read.csv('C:/R-3.3.2/2.csv')");
		re.eval(" result <- grm(data) ");
		re.eval(" est <- factor.scores(result) ");
		REXP x = re.eval(" est$score.dat$z1");
		double[] estimateThetaList = x.asDoubleArray();

		ArrayList<Double> list = new ArrayList<Double>();
		for (int i = 0; i < estimateThetaList.length; i++) {
			list.add(estimateThetaList[i]);
		}
		re.end(); // stop the Rengine
		return list;

	}

	public static void main(String args[]) {
		new rJava().estimateTheta();
	}
}