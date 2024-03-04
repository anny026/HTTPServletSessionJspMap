import shop.Products;
import shop.ProductsForShop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(asyncSupported = false, name = "ShopServlet", urlPatterns = { "/hello" })
public class ShopServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String submit = request.getParameter("submitForm");
        if (submit == null){
            submit = "browse";
            System.out.println("browse");
        }
        if (submit.equalsIgnoreCase("addToCart")) {
            addItem(request, response);
            request.getRequestDispatcher("page3.jsp")
                    .forward(request, response);}
        if (submit.equalsIgnoreCase("Submit")) {
            addSubmit(request, response);
            request.getRequestDispatcher("page4.jsp")
                    .forward(request, response);
        }
        }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
       HttpSession session = request.getSession();
        String name = (String) request.getParameter("name");
        session.setAttribute("name", name);

        if (request.getParameter("agree")!=null){
        request.getRequestDispatcher("page2.jsp")
                .forward(request,response);}
        else {
            request.getRequestDispatcher("pageOops.jsp")
                    .forward(request,response);}
        }


    private void addItem(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
       HttpSession session = req.getSession();
        if (session.getAttribute("cart") == null) {
            session.setAttribute("cart", new ArrayList<String>());
        }

        Integer shopCart= (Integer) session.getAttribute("shopCart");
        if (shopCart == null) {
            shopCart=0;  }
        Integer keyyyy = Integer.parseInt(req.getParameter("item"));
        Integer priceItem=ProductsForShop.getPricebyKey(keyyyy);
        shopCart+= priceItem;
        session.setAttribute("shopCart", shopCart);

        Products itemCart=ProductsForShop.getProductbyKey(keyyyy);
        ArrayList<Products> cart = (ArrayList<Products>) session.getAttribute("cart");
        cart.add(itemCart);
        req.setAttribute("cart", cart);
    }
    private void addSubmit(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("cart") == null) {
            session.setAttribute("cart", new ArrayList<String>());
        }
        Integer shopCart= (Integer) session.getAttribute("shopCart");
        if (shopCart == null) {
            shopCart=0;  }
        session.setAttribute("shopCart", shopCart);

        ArrayList<Products> cart = (ArrayList<Products>) session.getAttribute("cart");
        req.setAttribute("cart", cart);
    }
}
