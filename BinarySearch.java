
public class BinarySearch extends SearchAlgorithm {
	/**
	 * Iterative binary search
	 * 
	 * @param array
	 * @param x
	 */
	public int search(String[] array, String x) throws ItemNotFoundException {
		resetCount();
		int min = 0;
		int max = array.length - 1;

		while (min <= max) {
			int mid = (min + max) / 2;

			if (array[mid].equals(x)) {
				incrementCount();
				return mid;
			} else if (array[mid].compareTo(x) < 0) {
				incrementCount();
				min = mid + 1;
			} else if (array[mid].compareTo(x) > 0) {
				incrementCount();
				max = mid - 1;
			} else {
				return mid;
			}
		}
		throw new ItemNotFoundException("Target not found");
	}

	/**
	 * recursive search
	 * 
	 * @param array
	 * @param x
	 * @return binarySearchHelper()
	 */
	public int recSearch(String[] array, String x) throws ItemNotFoundException {
		resetCount();

		return binarySearchHelper(array, x, 0, array.length - 1);
	}

	/**
	 * recursive binary search
	 * 
	 * @param array
	 * @param x
	 * @param min
	 * @param max
	 * @return binarySearchHelper()
	 * @throws ItemNotFoundException
	 */
	public int binarySearchHelper(String[] array, String x, int min, int max) throws ItemNotFoundException {
		if (min > max) {
			throw new ItemNotFoundException("Target not found");
		} else {
			int middle = (min + max) / 2;

			if (array[middle].equals(x)) {
				incrementCount();
				return middle;
			} else if (array[middle].compareTo(x) < 0) {
				incrementCount();

				return binarySearchHelper(array, x, middle + 1, max);
			} else if (array[middle].compareTo(x) > 0) {
				incrementCount();

				return binarySearchHelper(array, x, min, middle - 1);
			} else {
				return middle;
			}
		}
	}
}
