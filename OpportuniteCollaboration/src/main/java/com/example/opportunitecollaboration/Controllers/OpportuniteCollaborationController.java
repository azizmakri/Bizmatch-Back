package com.example.opportunitecollaboration.Controllers;

import com.example.opportunitecollaboration.Entities.*;
import com.example.opportunitecollaboration.Services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/opportuniteCollaboration")
public class OpportuniteCollaborationController {

    @Autowired
    public ArticleBlogService articleBlogService;

    @Autowired
    public CategorieService categorieService;

    @Autowired
    public CommentaireService commentaireService;

    @Autowired
    public OpportuniteCollaborationService opportuniteCollaborationService;

    @Autowired
    public UserService userService;


    @PostMapping("/addArticleBlog")
    public ArticleBlog addArticleBlog(@RequestBody ArticleBlog articleBlog){
        return articleBlogService.addArticleBlog(articleBlog);
    };

    @PostMapping("/updateArticleBlog")
    public ArticleBlog updateArticleBlog(@RequestBody ArticleBlog articleBlog){
        return articleBlogService.updateArticleBlog(articleBlog);
    };

    @GetMapping("/retrieveArticleBlogById/{idArticleBlog}")
    public ArticleBlog retrieveArticleBlogById(@PathVariable Long idArticleBlog){
        return articleBlogService.retrieveArticleBlogById(idArticleBlog);
    };

    @GetMapping("/retrieveAllArticlesBlog")
    public List<ArticleBlog> retrieveAllArticlesBlog(){
        return articleBlogService.retrieveAllArticlesBlog();
    };

    @PutMapping("/deleteArticleBlog/{idArticleBlog}")
    public Boolean deleteArticleBlog(@PathVariable Long idArticleBlog){
        return articleBlogService.deleteArticleBlog(idArticleBlog);
    };






    @PostMapping("/addCategorie")
    public Categorie addCategorie(@RequestBody Categorie categorie){
        return categorieService.addCategorie(categorie);
    };

    @PostMapping("/updateCategorie")
    public Categorie updateCategorie(@RequestBody Categorie categorie){
        return categorieService.updateCategorie(categorie);
    };

    @GetMapping("/retrieveCategorieById/{idCategorie}")
    public Categorie retrieveCategorieById(@PathVariable Long idCategorie){
        return categorieService.retrieveCategorieById(idCategorie);
    };

    @GetMapping("/retrieveAllCategories")
    public List<Categorie> retrieveCategories(){
        return categorieService.retrieveAllCategories();
    };

    @PutMapping("/deleteCategorie/{idCategorie}")
    public Boolean deleteCategorie(@PathVariable Long idCategorie){
        return categorieService.deleteCategorie(idCategorie);
    };





    @PostMapping("/addCommentaire")
    public Commentaire addCommentaire(@RequestBody Commentaire commentaire){
        return commentaireService.addCommentaire(commentaire);
    };

    @PostMapping("/updateCommentaire")
    public Commentaire updateCommentaire(@RequestBody Commentaire Commentaire){
        return commentaireService.updateCommentaire(Commentaire);
    };

    @GetMapping("/retrieveCommentaireById/{idCommentaire}")
    public Commentaire retrieveCommentaireById(@PathVariable Long idCommentaire){
        return commentaireService.retrieveCommentaireById(idCommentaire);
    };

    @GetMapping("/retrieveAllCommentaires")
    public List<Commentaire> retrieveCommentaires(){
        return commentaireService.retrieveAllCommentaires();
    };

    @PutMapping("/deleteCommentaire/{idCommentaire}")
    public Boolean deleteCommentaire(@PathVariable Long idCommentaire){
        return commentaireService.deleteCommentaire(idCommentaire);
    };





    @PostMapping("/addOpportuniteCollaboration")
    public OpportuniteCollaboration addOpportuniteCollaboration(@RequestBody OpportuniteCollaboration opportuniteCollaboration){
        return opportuniteCollaborationService.addOpportuniteCollaboration(opportuniteCollaboration);
    };

    @PostMapping("/updateOpportuniteCollaboration")
    public OpportuniteCollaboration updateOpportuniteCollaboration(@RequestBody OpportuniteCollaboration opportuniteCollaboration){
        return opportuniteCollaborationService.updateOpportuniteCollaboration(opportuniteCollaboration);
    };

    @GetMapping("/retrieveOpportuniteCollaborationById/{idOpportuniteCollaboration}")
    public OpportuniteCollaboration retrieveOpportuniteCollaborationById(@PathVariable Long idOpportuniteCollaboration){
        return opportuniteCollaborationService.retrieveOpportuniteCollaborationById(idOpportuniteCollaboration);
    };

    @GetMapping("/retrieveAllOpportunitesCollaboration")
    public List<OpportuniteCollaboration> retrieveOpportuniteCollaborations(){
        return opportuniteCollaborationService.retrieveAllOpportunitesCollaboration();
    };

    @PutMapping("/deleteOpportuniteCollaboration/{idOpportuniteCollaboration}")
    public Boolean deleteOpportuniteCollaboration(@PathVariable Long idOpportuniteCollaboration){
        return opportuniteCollaborationService.deleteOpportuniteCollaboration(idOpportuniteCollaboration);
    };




    @PostMapping("/adduser")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    };

    @PostMapping("/updateuser")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    };

    @GetMapping("/retrieveuserbyid/{idUser}")
    public User retrieveUserById(@PathVariable String idUser){
        return userService.retrieveUserById(idUser);
    };

    @GetMapping("/retrieveallusers")
    public List<User> retrieveAllUsers(){
        return userService.retrieveAllUsers();
    };

    @PutMapping("/deleteuser/{idUser}")
    public Boolean deleteUser(@PathVariable String idUser){
        return userService.deleteUser(idUser);
    };

}
