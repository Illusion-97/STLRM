package dwn.slrm.business.resume;

import dwn.slrm.generic.Constants;
import dwn.slrm.generic.controllers.AbstractController;
import dwn.slrm.generic.exceptions.UnauthorizedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(Constants.RESUME_PREFIX)
public class ResumeController extends AbstractController<Resume,ResumeDto,ResumeService> {
    protected ResumeController(ResumeService service) {
        super(service, Constants.RESUME_PREFIX);
    }

    @Override
    public String all(Model model) {
        throw new UnauthorizedException();
    }
}
