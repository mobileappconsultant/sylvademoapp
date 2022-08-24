//
//  SideMenuViewController.swift
//  ios
//
//  Created by Joseph Peter on 24/08/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import UIKit

class SideMenuViewController: UIViewController {
    @IBOutlet weak var mainVH:UIView!
    @IBOutlet weak var mainVHTrailingConstraint:NSLayoutConstraint!
    @IBOutlet weak var dismissView: UIView!
    var navhandler:((String) -> Void)? = nil
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        dismissView.isUserInteractionEnabled = true
        let tapView = UITapGestureRecognizer(target: self, action: #selector(self.handleTapView(_:)))
        dismissView.addGestureRecognizer(tapView)
        animateConstraints()
    }
    
    func animateConstraints(){
        
        self.mainVHTrailingConstraint.constant = UIScreen.main.bounds.width - 50
        DispatchQueue.main.asyncAfter(deadline: .now() + 0.2, execute: {
        UIView.animate(withDuration: 0.6) {
            self.mainVHTrailingConstraint.constant = 150
            self.view.layoutIfNeeded()
            self.mainVH.layoutIfNeeded()
        }
        })
    }
    
    @objc func handleTapView(_ sender: UITapGestureRecognizer? = nil) {
        closeDrawer()
    }
    
    func closeDrawer(completion:(() -> Void)? = nil){
        UIView.animate(withDuration: 0.6) {
            self.mainVHTrailingConstraint.constant = UIScreen.main.bounds.size.width - 20
            self.view.layoutIfNeeded()
            self.mainVH.layoutIfNeeded()
        }
        DispatchQueue.main.asyncAfter(deadline: .now() + 0.5, execute: {
            self.dismiss(animated: false, completion: completion)
        })
    }
    
    
    ///buttons handlers
    
    @IBOutlet weak var homeV: UIView!
    @IBAction func gotoHomeAction(_ sender: Any) {
        self.showVC(identifier: "home")
    }
    @IBOutlet weak var appointmentV: UIView!
    @IBAction func gotoAppointmentAction(_ sender: Any) {
    }
    
    @IBOutlet weak var carerV: UIView!
    @IBAction func gotoCarerAction(_ sender: Any) {
        showVC(identifier: "carer")
    }
    
    @IBOutlet weak var communicationV: UIView!
    @IBAction func gotoCommunicationAction(_ sender: Any) {
        showVC(identifier: "communication")
    }
    
    @IBOutlet weak var careNoteV: UIView!
    @IBAction func gotoCareNoteAction(_ sender: Any) {
    }
    
    @IBOutlet weak var usageV: UIView!
    @IBAction func gotoUsageAndCostAction(_ sender: Any) {
    }
    
    @IBOutlet weak var helpV: UIView!
    @IBAction func gotoHelpAction(_ sender: Any) {
    }
    
    @IBOutlet weak var settingV: UIView!
    @IBAction func gotoSettingAction(_ sender: Any) {
    }
    
    @IBOutlet weak var logoutV: UIView!
    @IBAction func gotoLogoutAction(_ sender: Any) {
        showVC(identifier: "login")
    }
    
    
    func showVC(identifier: String){
        if(navhandler != nil){
            closeDrawer{
                self.navhandler!(identifier)
            }
        }
    }
}
