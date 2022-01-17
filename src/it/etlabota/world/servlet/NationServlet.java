package it.etlabota.world.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.etlabota.world.dto.NationDto;
import it.etlabota.world.service.NationService;
import it.etlabota.world.service.impl.NationServiceImpl;

public class NationServlet extends HttpServlet {

	private NationService nationService = new NationServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
		Long id = null;
		try {
			id = Long.parseLong(idStr);
		} catch (Exception e) {
			System.out.println("No id: returning all nations");
		}

		if (id == null) {
			List<NationDto> nations = nationService.getAll();
			req.setAttribute("nations", nations);
			req.getRequestDispatcher("jsp/nations.jsp").forward(req, resp);
		} else {
			NationDto dto = nationService.getOne(id);
			req.setAttribute("nation", dto);
			req.getRequestDispatcher("jsp/nation.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
