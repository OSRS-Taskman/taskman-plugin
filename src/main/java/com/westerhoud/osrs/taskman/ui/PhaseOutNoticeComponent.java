package com.westerhoud.osrs.taskman.ui;

import com.westerhoud.osrs.taskman.domain.Task;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.components.shadowlabel.JShadowedLabel;
import net.runelite.client.ui.overlay.components.LayoutableRenderableEntity;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.LinkBrowser;

public class PhaseOutNoticeComponent extends JPanel {
  private JLabel title = new JShadowedLabel("ATTENTION!");
  private JLabel body = new JShadowedLabel(
      "<html>This plugin is no longer maintained and <b>will stop working by the end of August 2026!</b>"
          + "<br /><br />Please migrate to the"
          + " <a style=\"color: white;\" href=\"\">Collection Log Master</a>"
          + " plugin to keep tasking.</html>"
  );

  public PhaseOutNoticeComponent() {
    setBorder(new EmptyBorder(8, 8, 8, 8));
    setLayout(new DynamicGridLayout(0, 1, 0, 3));
    setBackground(new Color(128, 32, 32));

    add(title);
    title.setHorizontalAlignment(SwingConstants.CENTER);
    title.setFont(new Font("Arial Black", Font.BOLD, 16));

    body.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    body.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        LinkBrowser.browse("https://runelite.net/plugin-hub/show/collection-log-master");
      }
    });
    add(body);
  }
}
