package mmarini.unitn.team04_matchweb.controller;

import mmarini.unitn.team04_matchweb.model.Review;
import mmarini.unitn.team04_matchweb.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public String showReviews(Model model) {
        List<Review> reviews = reviewService.getAllReviews();

        float sum = 0;
        for (Review review : reviews) {
            sum += review.getRating();
        }
        float avg = sum / reviews.size();


        model.addAttribute("reviews", reviews);
        model.addAttribute("average", avg);
        return "reviews";
    }
}
