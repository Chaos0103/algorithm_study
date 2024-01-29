			}
			
			// 길이가 4미만일 경우 앞에 0을 붙임
			while (str.length() < 4) {
				str = "0" + str;
			}
			
			ipv6.add(str);
		}
		
		String[] answer = new String[8];
		
		int idx = 0;
		int zeroCnt = 8 - ipv6.size() + 1; // 0으로만 이루어진 그룹 개수 (zero가 포함되어 있기 때문에 +1을 해줌)
		
		for (String str : ipv6) {
			if (str.equals("zero")) {
				// 0으로 이루어진 그룹 개수만큼 0000을 붙여줌
				while (zeroCnt-- > 0) {
					answer[idx++] = "0000";
				}
			} else {
				answer[idx++] = str;
			}
		}
		
		System.out.println(String.join(":", answer));

	}

}
