package other;

import java.util.concurrent.TimeUnit;
@SuppressWarnings("unused")
public enum MyTimeEnum {
	NANOSECONDS {
		public long toNanos(long d)   { return d; }
		public long toMicros(long d)  { return d/(C1/C0); }
		public long toMillis(long d)  { return d/(C2/C0); }
		public long toSeconds(long d) { return d/(C3/C0); }
		public long toMinutes(long d) { return d/(C4/C0); }
		public long toHours(long d)   { return d/(C5/C0); }
		public long toDays(long d)    { return d/(C6/C0); }
		public long convert(long d, TimeUnit u) { return u.toNanos(d); }
		int excessNanos(long d, long m) { return (int)(d - (m*C2)); }
	},

	/**
	 * Time unit representing one thousandth of a millisecond
	 */
	MICROSECONDS {
		public long toNanos(long d)   { return x(d, C1/C0, MAX/(C1/C0)); }
		public long toMicros(long d)  { return d; }
		public long toMillis(long d)  { return d/(C2/C1); }
		public long toSeconds(long d) { return d/(C3/C1); }
		public long toMinutes(long d) { return d/(C4/C1); }
		public long toHours(long d)   { return d/(C5/C1); }
		public long toDays(long d)    { return d/(C6/C1); }
		public long convert(long d, TimeUnit u) { return u.toMicros(d); }
		int excessNanos(long d, long m) { return (int)((d*C1) - (m*C2)); }
	};
	// Handy constants for conversion methods
	static final long C0 = 1L;
	static final long C1 = C0 * 1000L;
	static final long C2 = C1 * 1000L;
	static final long C3 = C2 * 1000L;
	static final long C4 = C3 * 60L;
	static final long C5 = C4 * 60L;
	static final long C6 = C5 * 24L;
	static final long MAX = Long.MAX_VALUE;

	static long x(long d, long m, long over) {
		if (d >  over) return Long.MAX_VALUE;
		if (d < -over) return Long.MIN_VALUE;
		return d * m;
	}
	public long toMillis(long duration) {
		throw new AbstractMethodError();
	}
	public void printEnum(long time){
		long ms = toMillis(time);
		System.out.println(ms);
	}
}
