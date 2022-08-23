//
//  CareContact.swift
//  ios
//
//  Created by Joseph Peter on 23/08/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import UIKit

class CareContact: UIView {

    @IBOutlet var contentView: UIView!
    @IBOutlet weak var imageV: UIImageView!
    @IBOutlet weak var title: UILabel!
    @IBOutlet weak var name: UILabel!
    
    @IBInspectable var titleV: String {
        get {
            return title.text ?? ""
        }
        set {
           title.text = newValue
        }
    }
    
    @IBInspectable var nameV: String {
        get {
            return name.text ?? ""
        }
        set {
            name.text = newValue
        }
    }
    
    @IBInspectable var image: UIImage {
        get {
            return imageV.image ?? UIImage.init(named: "owoman")!
        }
        set {
            imageV.image = newValue
        }
    }
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        commonInit()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        commonInit()
    }
    
    private func commonInit(){
        Bundle.main.loadNibNamed("care_contact", owner: self, options: nil)
        addSubview(contentView)
        contentView.frame  = self.bounds
        contentView.autoresizingMask = [.flexibleTopMargin, .flexibleBottomMargin, .flexibleLeftMargin , .flexibleRightMargin]
    }

}
