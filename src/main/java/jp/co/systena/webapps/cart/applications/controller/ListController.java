package jp.co.systena.webapps.cart.applications.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.webapps.cart.applications.model.Cart;
import jp.co.systena.webapps.cart.applications.model.Item;
import jp.co.systena.webapps.cart.applications.model.ListForm;
import jp.co.systena.webapps.cart.applications.model.ListService;

@Controller
public class ListController {

  @Autowired
  HttpSession session;
  /**
   *
   * @param mav
   * @return
   *
   * 商品一覧を表示
   */
  @RequestMapping(value="/ListView", method=RequestMethod.GET)
   public ModelAndView show(ModelAndView mav) {

    session.removeAttribute("listForm");

    ListForm listForm = new ListForm();
    mav.addObject("listForm",listForm);

    ListService listService = new ListService();
    List<Item> itemlist = listService.getItemList();
    mav.addObject("itemlist", itemlist);

    BindingResult bindingResult = (BindingResult) session.getAttribute("result");
    if (bindingResult != null) {
      mav.addObject("bindingResult", bindingResult);
    }
    // Viewのテンプレート名を設定
    mav.setViewName("ListView");
    return mav;
  }

  /**
   *
   * @param mav
   * @param listForm
   * @param bindingResult
   * @param request
   * @return
   * @throws ApplicationException
   *
   * Controllerクラス
   *
   * {cart}にセッションからカート内情報を設定
   * {cart} == nullの場合
   * 　新規でカートクラスを作成する
   * mav.addObject("cart", {cart})
   * mav.setViewName("ResultView")
   *
   */
  @RequestMapping(value="/CartInfo", method=RequestMethod.POST)
  public ModelAndView order(ModelAndView mav,
      @Valid ListForm listForm,
      BindingResult bindingResult,
      HttpServletRequest request) throws ApplicationException{

    Cart cart = (Cart) session.getAttribute("cart");
    if (cart == null) {

      cart = new Cart();
      session.setAttribute("cart", cart);
    }
    if (!bindingResult.getAllErrors().isEmpty()) {

      mav.addObject("listForm",listForm);

      mav.addObject("cart", cart);


      mav.setViewName("ListView");
      return mav;

    }

    mav.addObject("cart",cart);
    mav.setViewName("CartInfo");
    return mav;

  }

}
