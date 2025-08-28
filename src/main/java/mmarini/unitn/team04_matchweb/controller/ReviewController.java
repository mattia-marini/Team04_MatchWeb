package mmarini.unitn.team04_matchweb.controller;

import mmarini.unitn.team04_matchweb.model.entity.Review;
import mmarini.unitn.team04_matchweb.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.time.LocalDateTime;
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
        return "public/reviews";
    }

    @GetMapping("/write-review")
    public String writeReviewPage() {
        return "user/write-review";
    }

    @GetMapping("/review-submitted")
    public String reviewSubmittedPage() {
        return "info-pages/review-submitted";
    }


    // Api
    @PostMapping("/api/write-review")
    public String submitReview(@RequestParam("rating") int rating,
                               @RequestParam("reviewContent") String reviewContent,
                               Principal principal,
                               RedirectAttributes redirectAttributes) {
        try {
            // Get the currently logged-in user
            String username = principal.getName();

            // Create review
            Review review = new Review();
            review.setUsername(username);
            review.setRating(rating);
            review.setText(reviewContent);
            review.setCreatedAt(LocalDateTime.now());

            // Save it
            reviewService.saveReview(review);

            // Success message
            redirectAttributes.addFlashAttribute("successMessage", "Recensione inviata con successo!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Errore durante l'invio della recensione.");
        }

        return "redirect:/review-submitted";
    }


}
