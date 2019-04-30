private static String fromDecToHex(int in) {
		String res = "", rDigit = "";
		int q = in, r = 0, base = 16;
		do {
			q = in / base;
			r = in % base;
			// cast r value
			rDigit = String.valueOf(r);
			if (r > 9 && r < 16) {
				for (String[] arr : HEX) {
					if (arr[1].equals(String.valueOf(rDigit))) {
						rDigit = arr[0];
						break;
					}
				}
			}
			if (q >= 10 && q < base) {
				for (String[] arr : HEX) {
					if (arr[1].equals(String.valueOf(q))) {
						res += arr[0];
						if (r < base) {
							res = rDigit + res;
						}
						break;
					}
				}
			} else if (q < 10) {
				res = "" + q + rDigit + res;
			} else {
				res = "" + rDigit + res;
			}
			if (q > base) {
				in = q;
			} else {
				break;
			}
			// res = reverse(res);
		} while (r != 0);
		return writeOntwoDigit(res);
	}

private static String writeOntwoDigit(String in) {
		String out = "";
		if (in.length() % 2 == 1) {
			in = "0"+in;
		}
		for(int i=0; i<in.length(); i++) {
			out += in.charAt(i);
			if(i%2!=0) {
				out +=":";
			}
		}
		in = out.charAt(out.length()-1) == ':' ? out.substring(0, out.length()-1):out;
		return in;
	}
