function UIWidget() {
	
};

UIWidget.prototype.init = function(factoryId) {
	var DOMUtil = eXo.core.DOMUtil ;
	var uiWidgetContainer ;
	
	if(factoryId == null) {
		uiWidgetContainer = document.getElementById("UIWidgetContainer");
	} else {
		uiWidgetContainer = document.getElementById("UIPageDesktop") ;
	}
	
	var uiWidgets = DOMUtil.findDescendantsByClass(uiWidgetContainer, "div", "UIWidget");
	
	for(var i = 0; i < uiWidgets.length; i++) {
		uiWidgets[i].onmouseover = eXo.widget.UIWidget.showWidgetControl ;
		uiWidgets[i].onmouseout = eXo.widget.UIWidget.hideWidgetControl ;
	}
	
};

UIWidget.prototype.showWidgetControl = function() {
	var uiWidget = this ;
	var widgetControl = eXo.core.DOMUtil.findFirstDescendantByClass(uiWidget, "div", "WidgetControl");
	widgetControl.style.display = "block" ;
};

UIWidget.prototype.hideWidgetControl = function() {
	var uiWidget = this ;
	var widgetControl = eXo.core.DOMUtil.findFirstDescendantByClass(uiWidget, "div", "WidgetControl");
	widgetControl.style.display = "none" ;
};

eXo.widget.UIWidget = new UIWidget();