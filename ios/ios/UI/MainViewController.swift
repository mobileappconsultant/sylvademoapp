import UIKit
import SwiftUI

struct MainViewController: UIViewControllerRepresentable {

    func makeUIViewController(context: Context) -> some UIViewController {
        let storyboard = UIStoryboard(name: "main", bundle: Bundle.main)
        let controller = storyboard.instantiateInitialViewController()!
        return controller
    }
    
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {
        
    }
}
