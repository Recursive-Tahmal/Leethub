int mySqrt(int x) {
	long num = 1;
	while (num <= x)
	{
		if (num * num == x) {
			return num;
		}
		else if (num * num > x) {
			return num - 1;
		}

		++num;
	}
	return 0;
}