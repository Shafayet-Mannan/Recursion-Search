
public class LinearSearch extends SearchAlgorithm {

	/**
	 * @param array
	 * @param x
	 */
	public int search(String[] array, String x) throws ItemNotFoundException {
		resetCount();

		for (int i = 0; i < array.length; i++) {
			incrementCount();

			if (array[i].equals(x))
				return i;
		}
		throw new ItemNotFoundException("Target not found");
	}

	/**
	 * method for recursive search
	 * 
	 * @param array
	 * @param x
	 * @return recSearchHelper
	 */
	public int recSearch(String[] array, String x) throws ItemNotFoundException {
		resetCount();

		return recSearchHelper(array, x, 0, array.length - 1);
	}

	/**
	 * helper method for recSearch()
	 * 
	 * @param array
	 * @param x
	 * @param min
	 * @param max
	 * @return recSearchHelper
	 * @throws ItemNotFoundException
	 */
	public int recSearchHelper(String[] array, String x, int min, int max) throws ItemNotFoundException {
		if (min > max)
			throw new ItemNotFoundException("Target not found");

		else if (array[min].equals(x)) {
			incrementCount();

			return min;
		} else {
			incrementCount();

			return recSearchHelper(array, x, min + 1, max);
		}
	}
}
