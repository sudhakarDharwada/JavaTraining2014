public void employeepresent(HashMap<Integer, String> map2,String date)
	{
		HashSet<Integer> h1=new HashSet<Integer>();
		System.out.println(map2);
		for(int in:map2.keySet()){
			if(map2.get(in).equalsIgnoreCase(date)){
				h1.add(in);
			}
		}
		System.out.println("the no of employees:"+h1.size()+"emp id's on that day are:"+h1);
	}
