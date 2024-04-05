import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class SendButton extends Button{
  int page;
    public SendButton(String url,int x, int y, int page){
      super(url,x,y);
      this.page = page;
    }
  
    public void doTask(MouseEvent e){
      sendToPage(e);
    }
    public void sendToPage(MouseEvent e){
      if(clickedMe(e))
        MainFrame.setPage(page);
    }
  
}