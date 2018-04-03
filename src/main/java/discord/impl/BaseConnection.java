package discord.impl;

import org.apache.commons.lang3.SystemUtils;

/**
 * Base connection class
 *
 * Implementation is OS dependent
 */
public abstract class BaseConnection {
	static BaseConnection create() {
		if (SystemUtils.IS_OS_MAC_OSX)
			return new BaseConnectionOsx();

		if (SystemUtils.IS_OS_UNIX)
			return new BaseConnectionUnix();

		if (SystemUtils.IS_OS_WINDOWS)
			return new BaseConnectionWindows();

		throw new IllegalStateException("This OS is not supported"); //$NON-NLS-1$
	}

	static void destroy(BaseConnection baseConnection) {
		baseConnection.close();
	}

	BaseConnection() {
	}

	abstract boolean close();

	abstract boolean isOpen();

	abstract boolean open();

	abstract boolean read(byte[] bytes, int length, boolean wait);

	/**
	 * Register an application
	 *
	 * @param applicationId
	 *            Application ID
	 * @param command
	 *            Command to run the application
	 */
	public abstract void register(String applicationId, String command);

	/**
	 * Register a Steam application
	 *
	 * @param applicationId
	 *            Application ID
	 * @param steamId
	 *            Application Steam ID
	 */
	public abstract void registerSteamGame(String applicationId, String steamId);

	abstract boolean write(byte[] bytes, int length); // FIXME Lock over calls of that methods to unsure 2 threads are
														// not writing at the same time
}
