package hooks.accessors;

import hooks.Hooks;
import hooks.model.RSClass;

public class Class23 extends RSClass {

	int baseY;

	public Class23(Object reference) {
		this.reference = reference;
		if (Hooks.class23 != null) {
			this.fields = Hooks.class23.fields;
			this.name = Hooks.class23.name;
			this.obfuscatedName = Hooks.class23.obfuscatedName;
		}
	}

	public int getBaseY() {
		this.baseY = (int) getValue(getField("baseY"));
		return this.baseY;
	}
}
