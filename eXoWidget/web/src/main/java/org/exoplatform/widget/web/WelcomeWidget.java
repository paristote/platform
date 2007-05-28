/***************************************************************************
 * Copyright 2001-2007 The eXo Platform SARL         All rights reserved.  *
 * Please look at license.txt in info directory for more license detail.   *
 **************************************************************************/
package org.exoplatform.widget.web;

import java.io.Writer;

import org.exoplatform.portal.application.PortalRequestContext;
import org.exoplatform.portal.component.view.Util;
import org.exoplatform.web.application.mvc.MVCRequestContext;
import org.exoplatform.web.application.widget.WidgetApplication;

/**
 * Created by The eXo Platform SARL
 * Author : Pham Dung Ha
 *          ha.pham@exoplatform.com
 * May 25, 2007
 */
public class WelcomeWidget extends WidgetApplication {
  
  public String getApplicationId() { return "exo.widget.web/WelcomeWidget"; }

  public String getApplicationName() { return "WelcomeWidget"; }

  public String getApplicationGroup() { return "exo.widget.web"; }
  
  public void processRender(Writer w) throws Exception {
    PortalRequestContext pContext = Util.getPortalRequestContext();
    MVCRequestContext appReqContext = new MVCRequestContext(this, pContext) ;
    
//    UIPortal uiPortal = Util.getUIPortal();
//    UIPage uiPage = uiPortal.findFirstComponentOfType(UIPage.class);
//    String factoryId = uiPage.getFactoryId();
//        
//    System.out.println("\n\n\n\n\n\n\n\n FactoryID: "+factoryId+"  \n\n\n\n\n\n\n\n\n");
    
//    System.out.println("\n\n\n\n\n\n\n\n PROCESS RENDER WELCOME WIDGET  \n\n\n\n\n\n\n\n\n");
    
    w.write("<div id = 'UIWelcomeWidget'><span></span></div>") ;
    String script = 
      "eXo.portal.UIPortal.createJSApplication('eXo.widget.web.welcome.UIWelcomeWidget','UIWelcomeWidget','UIWelcomeWidget','/exo.widget.web/javascript/');";
    appReqContext.getJavascriptManager().addCustomizedOnLoadScript(script) ;
  }
}
