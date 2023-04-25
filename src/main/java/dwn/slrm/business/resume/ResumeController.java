package dwn.slrm.business.resume;

import dwn.slrm.generic.Constants;
import dwn.slrm.generic.controllers.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(Constants.RESUME_PREFIX)
public class ResumeController extends AbstractController<Resume,ResumeDto,ResumeService> {
    protected ResumeController(ResumeService service) {
        super(service, Constants.RESUME_PREFIX);
    }
}
