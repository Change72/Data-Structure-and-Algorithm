package practiseProblem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/***
 * 
 * @author change
 *
 * question:
 * 
 * 2：随机生成 Salary {name, baseSalary, bonus  }的记录，如“wxxx,10,1”，每行一条记录，总共1000万记录，写入文本文件（UFT-8编码），
 * 然后读取文件，name的前两个字符相同的，其年薪累加，比如wx，100万，3个人，最后做排序和分组，输出年薪总额最高的10组：
         wx, 200万，10人
         lt, 180万，8人
         ....
 * name 4位a-z随机，    baseSalary [0,100]随机 bonus[0-5]随机 年薪总额 = baseSalary*13 + bonus
 * 请努力将程序优化到5秒内执行完
 * 
 * 目前进展：
 * 随机生成 + 写入 9s + 0.65s
 * 读取 + 统计排序 9s + 0.015s
 */

public class EmployeeSalary {

	public class SalaryNode {
		String key;
		int val;
		int employee_num;

		SalaryNode next;

		public SalaryNode() {
		};

		public SalaryNode(String key, int val, int employee_num, SalaryNode next) {
			super();
			this.key = key;
			this.val = val;
			this.employee_num = employee_num;
			this.next = next;
		}

		@Override
		public String toString() {
			return "SalaryNode [key=" + key + ", val=" + val + ", employee_num=" + employee_num + "]";
		}
	}

	/**
	 * write to desk io
	 * 
	 * @param records
	 * @param bufSize
	 * @throws IOException
	 */
	public File writeBuffered(List<String> records, int bufSize) throws IOException {
		File file = new File("temp.txt");
		try {
			FileWriter writer = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(writer, bufSize);

			System.out.print("Writing buffered (buffer size: " + bufSize + ")... ");
			write(records, bufferedWriter);
			return file;
		} finally {
			// comment this out if you want to inspect the files afterward
			// file.delete();
		}
	}

	public void write(List<String> records, Writer writer) throws IOException {
		long start = System.currentTimeMillis();
		for (String record : records) {
			writer.write(record);
		}
		writer.flush();
		writer.close();
		long end = System.currentTimeMillis();
		System.out.println((end - start) / 1000f + " seconds");
	}

	/**
	 * generate random records
	 * 
	 * @throws IOException
	 */
	public File generateRecords() throws IOException {
		long begintime = System.currentTimeMillis();
		List<String> record = new ArrayList<String>();
		Random random = new Random();
		// �������
		for (int i = 0; i < 10000000; i++) {
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < 4; j++)
				sb.append(String.valueOf((char) (Math.round(Math.random() * 25 + 97))));
			record.add(sb.toString() + "," + String.valueOf(random.nextInt(101)) + ","
					+ String.valueOf(random.nextInt(6)) + "\r\n");
		}
		long endtime = System.currentTimeMillis();
		System.out.println("Generate 10 million records..." + (endtime - begintime) / 1000f + " seconds");
		return writeBuffered(record, 8192);
	}

	/**
	 * read from desk and statistics
	 * 
	 * @return
	 * @throws FileNotFoundException
	 */
	public Map<String, List<Integer>> statistics() throws FileNotFoundException {
		long begintime = System.currentTimeMillis();
		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(new File("temp.txt"), "UTF-8");
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String key = line.substring(0, 2);
			String[] infos = line.split(",");
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<Integer>(2));
				map.get(key).add(Integer.valueOf(infos[1]) * 13 + Integer.valueOf(infos[2]));
				map.get(key).add(1);
			} else {
				map.get(key).set(0, (map.get(key).get(0) + Integer.valueOf(infos[1]) * 13 + Integer.valueOf(infos[2])));
				map.get(key).set(1, map.get(key).get(1) + 1);
			}
		}

		long endtime = System.currentTimeMillis();
		System.out.println("Read and Statistics 10 million records..." + (endtime - begintime) / 1000f + " seconds");
		maxName(map);
		return map;
	}

	public void insertNode(SalaryNode head, SalaryNode target) {
		SalaryNode iterator = head.next;
		if (iterator == null) {
			head.next = target;
			return;
		}
		if (iterator.val > target.val) {
			target.next = iterator;
			head.next = target;
			return;
		}

		while (iterator.next != null) {
			if (iterator.next.val < target.val) {
				iterator = iterator.next;
				continue;
			}
			target.next = iterator.next;
			iterator.next = target;
			return;
		}
		iterator.next = target;
		return;
	}

	/**
	 * use list to queue most 10 answer
	 * 
	 * @param map
	 */
	public void maxName(Map<String, List<Integer>> map) {
		long begintime = System.currentTimeMillis();
		SalaryNode head = new SalaryNode();
		int i = 0;
		for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
			if (i < 10) {
				i++;
				insertNode(head,
						new SalaryNode(entry.getKey(), entry.getValue().get(0), entry.getValue().get(1), null));
			} else if (entry.getValue().get(0) > head.next.val) {
				head = head.next;
				insertNode(head,
						new SalaryNode(entry.getKey(), entry.getValue().get(0), entry.getValue().get(1), null));
			}
		}
		long endtime = System.currentTimeMillis();
		System.out.println("Filter top 10 records..." + (endtime - begintime) / 1000f + " seconds");
		while (head.next != null) {
			head = head.next;
			System.out.println(head.toString());
		}
	}

	public void testCase() throws IOException {
		File file = this.generateRecords();
		this.statistics();
		file.delete();
	}
}
