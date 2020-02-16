import matplotlib.patches as mpatches
from skimage.measure import label, regionprops
from skimage.color import label2rgb
import numpy as np

def get_roi_rect(input_image):
    label_image = label(input_image)
    mask_areas = []
    for region in regionprops(label_image):
        mask_areas.append(region.area)
    max_area = np.max(mask_areas)
    min_area = np.min(mask_areas)

    for region in regionprops(label_image):
        if region.area >= max_area:
            minr, minc, maxr, maxc = region.bbox
    return minr, minc, maxr, maxc, max_area, min_area