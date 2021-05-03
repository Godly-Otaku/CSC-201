package HW;

public class PhoneNumber {
	private String phoneNumber;

	public PhoneNumber() {
		phoneNumber = "(000) 000-0000";
	}

	public PhoneNumber(String phoneNumber) {
		setPhoneNumber(phoneNumber);
	}

	public void setPhoneNumber(String phoneNumber) {
		if (!isNumeric(phoneNumber)) {
			phoneNumber = "0000000000";
		} else if (phoneNumber.length() > 10)
			phoneNumber = phoneNumber.substring(0, 10);
		else {
			int code = Integer.parseInt(phoneNumber.substring(1, 4));
			if (code > 999 && code <= 200)
				phoneNumber = "0000000000";
		}
		this.phoneNumber = "(" + phoneNumber.substring(0, 3) + ") " + phoneNumber.substring(3, 6) + "-"
				+ phoneNumber.substring(6);
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String areaCode() {
		return phoneNumber.substring(1, 4);
	}

	public String areaCodeDescription() {
		String str = "Not a valid number";
		AreaCodeListing acl = new AreaCodeListing();
		String[] codes = acl.getValidCodes();
		String[] descriptions = acl.getValidDesc();
		for (int i = 0; i < codes.length; i++) {
			if (codes[i].equals(areaCode())) {
				str = descriptions[i];
				break;
			}
		}
		return str;
	}

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
