package org.apache.jsp.WEB_002dINF.flows.pizza.payment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class takePayment_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_form_input_path_cssStyle_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_form_form_name_commandName;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_form_radiobutton_value_path_onclick_label_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_form_input_path_cssStyle_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_form_form_name_commandName = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_form_radiobutton_value_path_onclick_label_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_form_input_path_cssStyle_nobody.release();
    _jspx_tagPool_form_form_name_commandName.release();
    _jspx_tagPool_form_radiobutton_value_path_onclick_label_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<div>\n");
      out.write("\n");
      out.write("  <script>\n");
      out.write("    function showCreditCardField() {\n");
      out.write("      var ccNumberStyle = document.paymentForm.creditCardNumber.style;\n");
      out.write("      ccNumberStyle.visibility = 'visible';\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    function hideCreditCardField() {\n");
      out.write("      var ccNumberStyle = document.paymentForm.creditCardNumber.style;\n");
      out.write("      ccNumberStyle.visibility = 'hidden';\n");
      out.write("    }    \n");
      out.write("  </script>\n");
      out.write("\n");
      out.write("\t<h2>Take Payment</h2>\n");
      out.write("\t");
      if (_jspx_meth_form_form_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("</div>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_form_form_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:form
    org.springframework.web.servlet.tags.form.FormTag _jspx_th_form_form_0 = (org.springframework.web.servlet.tags.form.FormTag) _jspx_tagPool_form_form_name_commandName.get(org.springframework.web.servlet.tags.form.FormTag.class);
    _jspx_th_form_form_0.setPageContext(_jspx_page_context);
    _jspx_th_form_form_0.setParent(null);
    _jspx_th_form_form_0.setCommandName("paymentDetails");
    _jspx_th_form_form_0.setName("paymentForm");
    int[] _jspx_push_body_count_form_form_0 = new int[] { 0 };
    try {
      int _jspx_eval_form_form_0 = _jspx_th_form_form_0.doStartTag();
      if (_jspx_eval_form_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t  <input type=\"hidden\" name=\"_flowExecutionKey\" \n");
          out.write("\t      value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${flowExecutionKey}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"/>\t      \n");
          out.write("\n");
          out.write("    ");
          if (_jspx_meth_form_radiobutton_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_0, _jspx_page_context, _jspx_push_body_count_form_form_0))
            return true;
          out.write("<br/> \n");
          out.write("    ");
          if (_jspx_meth_form_radiobutton_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_0, _jspx_page_context, _jspx_push_body_count_form_form_0))
            return true;
          out.write("<br/>\n");
          out.write("    ");
          if (_jspx_meth_form_radiobutton_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_0, _jspx_page_context, _jspx_push_body_count_form_form_0))
            return true;
          out.write("       \n");
          out.write("\t      \n");
          out.write("\t      \n");
          out.write("\t  ");
          if (_jspx_meth_form_input_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_0, _jspx_page_context, _jspx_push_body_count_form_form_0))
            return true;
          out.write("\n");
          out.write("\t\n");
          out.write("\t  <br/><br/>\n");
          out.write("\t  <input type=\"submit\" class=\"button\" \n");
          out.write("\t      name=\"_eventId_paymentSubmitted\" value=\"Submit\"/>\n");
          out.write("\t  <input type=\"submit\" class=\"button\" \n");
          out.write("\t      name=\"_eventId_cancel\" value=\"Cancel\"/>          \n");
          out.write("\t");
          int evalDoAfterBody = _jspx_th_form_form_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_form_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_form_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_form_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_form_0.doFinally();
      _jspx_tagPool_form_form_name_commandName.reuse(_jspx_th_form_form_0);
    }
    return false;
  }

  private boolean _jspx_meth_form_radiobutton_0(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:radiobutton
    org.springframework.web.servlet.tags.form.RadioButtonTag _jspx_th_form_radiobutton_0 = (org.springframework.web.servlet.tags.form.RadioButtonTag) _jspx_tagPool_form_radiobutton_value_path_onclick_label_nobody.get(org.springframework.web.servlet.tags.form.RadioButtonTag.class);
    _jspx_th_form_radiobutton_0.setPageContext(_jspx_page_context);
    _jspx_th_form_radiobutton_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_0);
    _jspx_th_form_radiobutton_0.setPath("paymentType");
    _jspx_th_form_radiobutton_0.setValue(new String("CASH"));
    _jspx_th_form_radiobutton_0.setLabel(new String("Cash (taken at delivery)"));
    _jspx_th_form_radiobutton_0.setOnclick("hideCreditCardField()");
    int[] _jspx_push_body_count_form_radiobutton_0 = new int[] { 0 };
    try {
      int _jspx_eval_form_radiobutton_0 = _jspx_th_form_radiobutton_0.doStartTag();
      if (_jspx_th_form_radiobutton_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_radiobutton_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_radiobutton_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_radiobutton_0.doFinally();
      _jspx_tagPool_form_radiobutton_value_path_onclick_label_nobody.reuse(_jspx_th_form_radiobutton_0);
    }
    return false;
  }

  private boolean _jspx_meth_form_radiobutton_1(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:radiobutton
    org.springframework.web.servlet.tags.form.RadioButtonTag _jspx_th_form_radiobutton_1 = (org.springframework.web.servlet.tags.form.RadioButtonTag) _jspx_tagPool_form_radiobutton_value_path_onclick_label_nobody.get(org.springframework.web.servlet.tags.form.RadioButtonTag.class);
    _jspx_th_form_radiobutton_1.setPageContext(_jspx_page_context);
    _jspx_th_form_radiobutton_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_0);
    _jspx_th_form_radiobutton_1.setPath("paymentType");
    _jspx_th_form_radiobutton_1.setValue(new String("CHECK"));
    _jspx_th_form_radiobutton_1.setLabel(new String("Check (taken at delivery)"));
    _jspx_th_form_radiobutton_1.setOnclick("hideCreditCardField()");
    int[] _jspx_push_body_count_form_radiobutton_1 = new int[] { 0 };
    try {
      int _jspx_eval_form_radiobutton_1 = _jspx_th_form_radiobutton_1.doStartTag();
      if (_jspx_th_form_radiobutton_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_radiobutton_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_radiobutton_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_radiobutton_1.doFinally();
      _jspx_tagPool_form_radiobutton_value_path_onclick_label_nobody.reuse(_jspx_th_form_radiobutton_1);
    }
    return false;
  }

  private boolean _jspx_meth_form_radiobutton_2(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:radiobutton
    org.springframework.web.servlet.tags.form.RadioButtonTag _jspx_th_form_radiobutton_2 = (org.springframework.web.servlet.tags.form.RadioButtonTag) _jspx_tagPool_form_radiobutton_value_path_onclick_label_nobody.get(org.springframework.web.servlet.tags.form.RadioButtonTag.class);
    _jspx_th_form_radiobutton_2.setPageContext(_jspx_page_context);
    _jspx_th_form_radiobutton_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_0);
    _jspx_th_form_radiobutton_2.setPath("paymentType");
    _jspx_th_form_radiobutton_2.setValue(new String("CREDIT_CARD"));
    _jspx_th_form_radiobutton_2.setLabel(new String("Credit Card:"));
    _jspx_th_form_radiobutton_2.setOnclick("showCreditCardField()");
    int[] _jspx_push_body_count_form_radiobutton_2 = new int[] { 0 };
    try {
      int _jspx_eval_form_radiobutton_2 = _jspx_th_form_radiobutton_2.doStartTag();
      if (_jspx_th_form_radiobutton_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_radiobutton_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_radiobutton_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_radiobutton_2.doFinally();
      _jspx_tagPool_form_radiobutton_value_path_onclick_label_nobody.reuse(_jspx_th_form_radiobutton_2);
    }
    return false;
  }

  private boolean _jspx_meth_form_input_0(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_form_input_0 = (org.springframework.web.servlet.tags.form.InputTag) _jspx_tagPool_form_input_path_cssStyle_nobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_form_input_0.setPageContext(_jspx_page_context);
    _jspx_th_form_input_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_0);
    _jspx_th_form_input_0.setPath("creditCardNumber");
    _jspx_th_form_input_0.setCssStyle("visibility:hidden;");
    int[] _jspx_push_body_count_form_input_0 = new int[] { 0 };
    try {
      int _jspx_eval_form_input_0 = _jspx_th_form_input_0.doStartTag();
      if (_jspx_th_form_input_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_input_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_input_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_input_0.doFinally();
      _jspx_tagPool_form_input_path_cssStyle_nobody.reuse(_jspx_th_form_input_0);
    }
    return false;
  }
}
