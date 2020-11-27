package ua.edu.ucu;

import org.junit.Test;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

import static org.junit.Assert.*;

/**
 *
 * @author Andrii_Rodionov
 */
public class SmartArrayAppTest {

    @Test
    public void testFilterPositiveIntegersSortAndMultiplyBy2() {
        Integer[] integers = {-1, 2, 0, 1, -5, 3};
        
        Integer[] res = 
                SmartArrayApp.filterPositiveIntegersSortAndMultiplyBy2(integers);
        Integer[] expectedRes = {2, 4, 6};
        
        assertArrayEquals(expectedRes, res);        
    }

    @Test
    public void testFindDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname() {
        Student[] students = {
            new Student("Ivar", "Grimstad", 3.9, 2),
            new Student("Ittai", "Zeidman", 4.5, 1),
            new Student("Antons", "Kranga", 4.0, 2),
            new Student("Burr", "Sutter", 4.2, 2),
            new Student("Philipp", "Krenn", 4.3, 3),
            new Student("Tomasz", "Borek", 4.1, 2),
            new Student("Ittai", "Zeidman", 4.5, 1),
            new Student("Burr", "Sutter", 4.2, 2)};
        String[] studentNames = 
                SmartArrayApp.findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(students);
        String[] expectedStudentNames = {"Borek Tomasz", "Kranga Antons", "Sutter Burr"};

        assertArrayEquals(expectedStudentNames, studentNames);
    }

    @Test
    public void testBaseArray() {
        BaseArray baseArray = new BaseArray(new Object[0]);
        assertEquals("BaseArray", baseArray.operationDescription());
    }

    @Test
    public void testDistinctDecorator() {
        SmartArray smartArray = new BaseArray(new Object[0]);
        DistinctDecorator dec = new DistinctDecorator(smartArray);
        assertEquals("DistinctDecorator", dec.operationDescription());
        assertEquals(0, dec.size());
    }

    @Test
    public void testFilterDecorator() {
        SmartArray smartArray = new BaseArray(new Object[0]);
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return false;
            }
        };
        FilterDecorator dec = new FilterDecorator(smartArray, pr);
        assertEquals("FilterDecorator", dec.operationDescription());
    }

    @Test
    public void testMapDecorator() {
        SmartArray smartArray = new BaseArray(new Object[0]);
        MyFunction fn = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return null;
            }
        };
        MapDecorator dec = new MapDecorator(smartArray, fn);
        assertEquals("MapDecorator", dec.operationDescription());
    }

    @Test
    public void testSortDecorator() {
        SmartArray smartArray = new BaseArray(new Object[0]);
        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
        SortDecorator dec = new SortDecorator(smartArray, cmp);
        assertEquals("SortDecorator", dec.operationDescription());
    }

    @Test
    public void testStudent() {
        Student student = new Student("Ivar", "Grimstad", 3.9, 2);
        assertEquals(student.toString(), "Student{name=Ivar, surname=Grimstad, GPA=3.9, year=2}");
    }
}