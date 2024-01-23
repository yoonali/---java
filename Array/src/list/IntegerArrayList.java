package list;

public class IntegerArrayList implements IntegerListInterface {
	
	private Integer[] item;
	private int numItems;
	//상수 구현
	private static final int DEFAULT_CAPACITY = 64;
	
	public IntegerArrayList() {
		//생성자를 파라미터 없이 호출하면 상수 DEFAULT_CAPACITY크기의 배열을 할당
		item = new Integer[DEFAULT_CAPACITY];
		//리스트의 원소들은 배열 item[]에 저장하는데 확보한 배열은 빈 리스트이므로 리스트의 총 원소 수를 관리하는 변수 numItems를 0으로 초기화한다.
		numItems = 0;
	}
	
	public IntegerArrayList(int n) {
		//파라미터가 주어지면(생성자 2의 n) 파라미터로 지정한 크기의 배열을 할당한다.
		item = new Integer[n];
		numItems = 0;
	}

	//배열 리스트의 k번째 자리에 원소 x 삽입하기 
	@Override
	public void add(int index, Integer x) {
		if(numItems >= item.length || index < 0 || index > numItems) {
			/* 에러처리 */
		} else {
			for (int i = numItems - 1; i>= index; i--) 
				item[i + 1] = item[i]; //우시프트
			item[index] = x;
			numItems++;
		}
		
	}

	//배열 리스트의 맨 뒤에 원소 추가하기 
	@Override
	public void append(Integer x) {
		if(numItems >= item.length) {
			/* 에러처리 */
		} else {
			item[numItems++] = x;
		}
		
	}

	//배열 리스트의 k번째 원소 삭제하기 
	@Override
	public Integer remove(int index) {
		if(isEmpty() || index < 0 || index > numItems - 1)
			return null;
		else {
			Integer tmp = item[index];
			for (int i = index; i <= numItems -2; i++)
				item[i] = item[i+1]; //좌 시프트
			numItems--;
			return tmp;
		}
	}

	//배열 리스트에서 원소 x 삭제하기
	@Override
	public boolean removeItem(Integer x) {
		int k = 0;
		while (k < numItems && item[k].compareTo(x) != 0)
			k++;
		if(k ==numItems)
			return false;
		else {
			for (int i = k; i <= numItems -2; i++)
				item[i] = item[i+1]; //좌 시프트
			numItems--;
			return true;
		}
	}

	//배열 리스트의 i번쨰 원소 알려주기
	@Override
	public Integer get(int index) {
		if(index >= 0 && index <= numItems - 1)
			return item[index];
		else
			return null;
	}

	//배열 리스트의  i번쨰 언소를 x로 대체하기 
	@Override
	public void set(int index, Integer x) {
		if(index >= 0 && index <= numItems -1)
			item[index] = x;
		else {/* 에러처리 */}
		
	}

	//원소 x가 배열 리스트의 몇 번째 원소인지 알려주기
	private final int NOT_FOUND = -12345;
	@Override
	public int indexOf(Integer x) {
		int i = 0;
		for (i = 0; i <numItems; i++) {
			if(((Comparable)item[i]).compareTo(x) == 0)
				return i;
		}
		return NOT_FOUND; //존재하지 않는다면 
	}

	//배열 리스트의 총 원소 수 알려주기 
	@Override
	public int len() {
		return numItems;
	}

	//배열 리스트가 비었는지 알려주기
	@Override
	public boolean isEmpty() {
		return numItems == 0;
	}

	//배열 리스트 깨끗이 청소하기
	@Override
	public void clear() {
		item = new Integer[item.length];
		numItems = 0;
		
	}
	

}
