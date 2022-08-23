//
//  UIView.swift
//  ios
//
//  Created by Joseph Peter on 22/08/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import UIKit

extension CALayer {
    
    func addBorder(edge: UIRectEdge, color: UIColor, thickness: CGFloat) {
        
        let border = CALayer();
        
        switch edge {
        case UIRectEdge.top:
            border.frame = CGRect(x: 0, y: 0, width: self.frame.width, height: thickness);
            break
        case UIRectEdge.bottom:
            border.frame = CGRect(x: 0, y: self.frame.height - thickness, width: self.frame.width, height: thickness)
            break
        case UIRectEdge.left:
            border.frame = CGRect(x: 0, y: 0, width: thickness, height: self.frame.height)
            break
        case UIRectEdge.right:
            border.frame = CGRect(x: self.frame.width - thickness, y: 0, width: thickness, height: self.frame.height)
            break
        default:
            break
        }
        
        border.backgroundColor = color.cgColor;
        
        self.addSublayer(border)
    }
    
}


/**
 Note Always set cornerRadius before shadow when you need both , to avoid weird behaivour
 */
@IBDesignable
class CView : UIView {
    
}


extension UIView {
    
    @IBInspectable var cornerRadiusV: CGFloat {
        get {
            return layer.cornerRadius
        }
        set {
            layer.cornerRadius = newValue
            layer.masksToBounds = newValue > 0
        }
    }
    
    @IBInspectable var borderWidthV: CGFloat {
        get {
            return layer.borderWidth
        }
        set {
            layer.borderWidth = newValue
        }
    }
    
    @IBInspectable var borderColorV: UIColor? {
        get {
            return UIColor(cgColor: layer.borderColor!)
        }
        set {
            layer.borderColor = newValue?.cgColor
        }
    }
    
    @IBInspectable
       var shadowRadius: CGFloat {
            get {
                return layer.shadowRadius
            }
            set {
                layer.shadowColor = #colorLiteral(red: 0, green: 0, blue: 0, alpha: 1).cgColor
                layer.shadowOffset = CGSize(width: 0, height: 2)
                layer.shadowOpacity = 0.3
                layer.masksToBounds = false
                layer.shadowRadius = newValue
            }
        }
    
}
