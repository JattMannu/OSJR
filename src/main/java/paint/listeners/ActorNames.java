package paint.listeners;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import game.Settings;
import hooks.Hooks;
import hooks.accessors.Client;
import hooks.accessors.Npc;
import hooks.accessors.Player;
import hooks.helpers.LocalPoint;
import hooks.helpers.Perspective;
import hooks.helpers.Point;

public class ActorNames implements PaintListener {

	public ActorNames(Client game) {
	}

	@Override
	public void onRepaint(Graphics g) {
		if (Hooks.client != null)
			if (Hooks.client.isLoggedIn()) {
				if (Settings.SHOW_PLAYER_NAMES) {
					g.setColor(Color.green);
					Player[] ps = Hooks.client.getCachedPlayers();
					if (ps != null) {
						for (Player pl : ps) {
							if (pl != null) {
								String name = pl.getNames().getName();
								Point p = Perspective.getCanvasTextLocation(Hooks.client, (Graphics2D) g,
										new LocalPoint(pl.asActor().getX(), pl.asActor().getY()), name, 200);
								if (p != null)
									g.drawString(name, p.getX(), p.getY());
							}

						}
					}

					g.setColor(Color.cyan);
					Npc[] ns = Hooks.client.getCachedNpcs();
					if (ns != null) {
						for (Npc pl : ns) {
							if (pl != null) {
								String name = pl.getNpcComposition().getName();
								if (name != null) {
									if (name.contains("Fishing")) { //$NON-NLS-1$
										String[] actions = pl.getNpcComposition().getActions();
										int i = 50;
										for (String s : actions) {
											if (s != null) {
												Point p1 = Perspective.getCanvasTextLocation(Hooks.client,
														(Graphics2D) g,
														new LocalPoint(pl.asActor().getX(), pl.asActor().getY()), s, i);
												if (p1 != null && name != null && name.compareTo("null") != 0) //$NON-NLS-1$
													g.drawString(s, p1.getX(), p1.getY());
												i -= 50;
											}
										}
									} else {
										Point p = Perspective.getCanvasTextLocation(Hooks.client, (Graphics2D) g,
												new LocalPoint(pl.asActor().getX(), pl.asActor().getY()), name, 190);
										if (p != null && name != null && name.compareTo("null") != 0) //$NON-NLS-1$
											g.drawString(name, p.getX(), p.getY());
									}
								}
							}
						}
					}
				}
			}

	}

}
